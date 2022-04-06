package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.myapp.adapter.ProfesseurAdapter;
import com.example.myapp.model.Professeur;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.LinkedList;

public class ProfesseursActivity extends AppCompatActivity {
    FloatingActionButton FabAdd;
    FirebaseFirestore db;
    LinkedList<Professeur> profs;
    RecyclerView.LayoutManager layoutManager;

    RecyclerView myrecycler;
            ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professeurs);
        FabAdd=findViewById(R.id.fabAdd);

        layoutManager = new LinearLayoutManager(this);


        db = FirebaseFirestore.getInstance();
        myrecycler=findViewById(R.id.myRecycler);
        profs=getAllProfesseurs();
        ProfesseurAdapter PA= new ProfesseurAdapter(profs,this);
        myrecycler.setAdapter(PA);

    }


    LinkedList<Professeur> getAllProfesseurs(){
        LinkedList<Professeur> profs= new LinkedList<Professeur>();
        db.collection("professeur")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Professeur prof = new Professeur(document.getString("Nom"),document.getString("Prenom").toString(),document.getString("Departement"),document.getString("Tel"),document.getString("Photo") );
                                profs.add(prof);
                            }
                        }
                    }
                });

        return profs;

    }

}