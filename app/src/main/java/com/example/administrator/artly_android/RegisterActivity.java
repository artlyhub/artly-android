package com.example.administrator.artly_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONStringer;

import java.util.HashMap;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {
    EditText idText;
    EditText firstText;
    EditText lastText;
    EditText emailText;
    Button registerButton;

    private Retrofit retrofit;
    private final String BASE_URL = "https://www.artlyhub.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        idText = (EditText) findViewById(R.id.idText);
        firstText = (EditText) findViewById(R.id.firstnameText);
        lastText = (EditText) findViewById(R.id.lastnameText);
        emailText = (EditText) findViewById(R.id.emailText);
        registerButton = (Button) findViewById(R.id.registerButton);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(idText.getText().toString(),firstText.getText().toString(),lastText.getText().toString(),emailText.getText().toString());
                Artly artly = retrofit.create(Artly.class);
                Call<User> call = artly.createUser(user);
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if(response.code()==201){
                            Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                            RegisterActivity.this.startActivity(intent);
                        }
                        else{
                            Toast.makeText(RegisterActivity.this,"회원가입 실패",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(RegisterActivity.this, "서비스 불가",Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }
}



