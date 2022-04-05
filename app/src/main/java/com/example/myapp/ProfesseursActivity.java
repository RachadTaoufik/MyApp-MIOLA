package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ProfesseursActivity extends AppCompatActivity {
    FloatingActionButton FabAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professeurs);

        FabAdd.findViewById(R.id.fabAdd);
    }
}