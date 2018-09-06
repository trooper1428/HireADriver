package com.example.optimusprime.hireadriver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Signupmain extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupmain);
        findViewById(R.id.IconOwner).setOnClickListener(this);
        findViewById(R.id.IconDriver).setOnClickListener(this);
        findViewById(R.id.textViewLoginGraph).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        {
            switch (v.getId()) {
                case R.id.IconOwner:
                    startActivity(new Intent(this, SignupActivity1.class));
                    break;
                case R.id.IconDriver:
                    startActivity(new Intent(this, SignupActivity1.class));
                    break;
                case R.id.textViewLoginGraph:
                    startActivity(new Intent(this, MainActivity.class));
                    break;
            }
        }

    }
}
