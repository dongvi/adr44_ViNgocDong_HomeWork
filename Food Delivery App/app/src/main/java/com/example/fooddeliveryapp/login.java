package com.example.fooddeliveryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.fooddeliveryapp.databinding.LoginActivityBinding;


public class login extends AppCompatActivity {

    LoginActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.login_activity);



        binding.btnSee.setVisibility(View.GONE);
        binding.btnNotSee.setVisibility(View.VISIBLE);

        binding.btnNotSee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnSee.setVisibility(View.VISIBLE);
                binding.btnNotSee.setVisibility(View.GONE);
                binding.etPassword.setTransformationMethod(null);
            }
        });

        binding.btnSee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnNotSee.setVisibility(View.VISIBLE);
                binding.btnSee.setVisibility(View.GONE);
                binding.etPassword.setTransformationMethod(new PasswordTransformationMethod());
            }
        });

        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Homepage.class);
                startActivity(intent);
            }
        });
    }
}