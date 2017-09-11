package com.example.administrator.artly_android.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.artly_android.Models.Artly;
import com.example.administrator.artly_android.Home.HomeActivity;
import com.example.administrator.artly_android.R;
import com.example.administrator.artly_android.Models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class LoginActivity extends AppCompatActivity {

    EditText idText;
    EditText passwordText;
    Button loginButton;
    Button registerButton;
    Boolean login = false;

    private Retrofit retrofit;
    private final String BASE_URL = "https://www.artlyhub.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        idText = (EditText) findViewById(R.id.idText);
        passwordText = (EditText) findViewById(R.id.passwordText);
        loginButton = (Button) findViewById(R.id.loginButton);
        registerButton = (Button) findViewById(R.id.registerButton);
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }


        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String userID = idText.getText().toString();
                final String userPassword = passwordText.getText().toString();
                Artly artly = retrofit.create(Artly.class);
                Call<List<User>> call = artly.login();

                call.enqueue(new Callback<List<User>>() {
                    @Override
                    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                        List<User> users = response.body();
                        for(User user : users){
                            if(userID.equals(user.username.toString())){
                                login = true;
                                break;
                            }
                        }
                        if(login){
                            Intent Intent = new Intent(LoginActivity.this, HomeActivity.class);
                            Intent.putExtra("userID",userID);
                            Intent.putExtra("userPassword",userPassword);
                            LoginActivity.this.startActivity(Intent);
                        }
                        else{
                            Toast.makeText(LoginActivity.this, "로그인 실패",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<User>> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "서비스 불가",Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }

}



