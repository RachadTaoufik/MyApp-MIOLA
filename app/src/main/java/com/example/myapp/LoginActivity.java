package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
    LinearLayout    linearLayout0;
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
        linearLayout0=findViewById(R.id.Layout_0);
    }
    @Override
    public void onClick(View view) {


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_1,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId()==R.id.item_red)
            linearLayout0.setBackgroundColor(Color.RED);
        else if(item.getItemId()==R.id.item_green)
            linearLayout0.setBackgroundColor(Color.GREEN);
        else if(item.getItemId()==R.id.item_yellow)
            linearLayout0.setBackgroundColor(Color.YELLOW);
        else if(item.getItemId()==R.id.item_About){
            Intent myIntent= new Intent(this, aboutActivity.class);
            startActivity(myIntent);}

        else if(item.getItemId()==R.id.item_Help){
            Intent email = new Intent();
            email.setData(Uri.parse("mailto:"));
            email.setAction(Intent.ACTION_SEND);
            email.putExtra(Intent.EXTRA_EMAIL, "rachad.taoufik@gmail.com");
            email.putExtra(Intent.EXTRA_SUBJECT, "Help");
            email.putExtra(Intent.EXTRA_TEXT, "Veuillez m'envoyer mes informations d'authentification");
            startActivity(Intent.createChooser(email,"Veuillez choisir une application..."));


        }

        return true;
    }

}