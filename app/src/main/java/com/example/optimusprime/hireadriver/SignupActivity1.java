package com.example.optimusprime.hireadriver;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class SignupActivity1 extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    EditText editTextEmail, editTextPassword;
    ProgressBar progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup1);

        findViewById(R.id.textViewLogin).setOnClickListener(this);
        findViewById(R.id.buttonSignUp).setOnClickListener(this);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        mAuth = FirebaseAuth.getInstance();
        progressbar=(ProgressBar) findViewById(R.id.progressbar);
    }

    private void reguser() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        if (email.isEmpty()) {
            editTextEmail.setError("Email is Mandatory!!");
            editTextEmail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Insert a valid Email!!");
            editTextEmail.requestFocus();
            return;
        }

        if(password.length()<8){
            editTextPassword.setError("minimum Length Should be 8");
            editTextPassword.requestFocus();
            return;

        }

        if (password.isEmpty()){
            editTextPassword.setError("Password is Mandatory!!");
            editTextPassword.requestFocus();
            return;
        }
    progressbar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressbar.setVisibility(View.GONE);
                if (task.isComplete()){
                    Toast.makeText(getApplicationContext(),"New User Registration Successful",Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getApplicationContext(),"Error Occoured:",Toast.LENGTH_SHORT);


            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textViewLogin:
                startActivity(new Intent(this, MainActivity.class));
                break;

            case R.id.buttonSignUp:
                reguser();
                break;
        }
    }

}