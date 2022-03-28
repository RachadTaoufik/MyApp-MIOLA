package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textview_state;
    Button button_login;
    Button button_logout;
    Button button_singup;
    LinearLayout    linearLayout1;
    LinearLayout    linearLayout2;
    LinearLayout    linearLayout3;
    LinearLayout    linearLayout4;
    EditText text_login;
    EditText text_password;

    Boolean visible=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textview_state=findViewById(R.id.user_state);
        button_login=findViewById(R.id.BTT_login);
        //...
        button_login.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {


    }
}