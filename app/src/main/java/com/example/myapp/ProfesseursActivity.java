package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapp.model.Professeur;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.LinkedList;

public class ProfesseursActivity extends AppCompatActivity{
    FloatingActionButton FabAdd;
    FirebaseFirestore db;
    LinkedList<Professeur> profs;
    ListView mylist;
    public ProgressDialog mProgressDialog;

            ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professeurs);
        FabAdd=findViewById(R.id.fabAdd);
        profs= new LinkedList<Professeur>();
        mylist=findViewById(R.id.list_profs);
        db = FirebaseFirestore.getInstance();


    }

    protected void onResume(){
        super.onResume();
        getAllProfesseurs();

    }



    void getAllProfesseurs(){
        showProgressDialog();
        db.collection("professeur")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                Professeur prof = new Professeur(document.getString("Nom"),document.getString("Prenom").toString(),document.getString("Departement"),document.getString("Tel"),document.getString("Photo") );
                                System.out.println("Un Prof"+prof.getNom());
                                profs.add(prof);
                            }

                        }
                        else
                            System.out.println("Erreur!!!!!");

                        ArrayList<String> noms_prof = new ArrayList<String>();
                        for(Professeur prof: profs){
                            noms_prof.add(prof.getNom());
                        }
                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ProfesseursActivity.this,android.R.layout.simple_list_item_1,noms_prof );
                        mylist.setAdapter(arrayAdapter);
                        hideProgressDialog();
                    }
                });
        System.out.println("La liste des profs :"+profs);
    }

    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage(getString(R.string.loading));
            mProgressDialog.setIndeterminate(true);
        }

        mProgressDialog.show();
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

}