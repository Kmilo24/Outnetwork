package com.example.outnetwork;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;

import android.view.View;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;


public class FundaEconomiaCl extends AppCompatActivity {
    private TextView texto,texto2,texto3,texto4,texto5,texto6,texto7,texto8,carga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funda_economia_cl);
        texto=findViewById(R.id.texto);
        carga=findViewById(R.id.carga1);
        texto2=findViewById(R.id.texto2);
        texto3=findViewById(R.id.texto3);
        texto4=findViewById(R.id.texto4);
        texto5=findViewById(R.id.texto5);
        texto6=findViewById(R.id.texto6);
        texto7=findViewById(R.id.texto7);
        texto8=findViewById(R.id.texto8);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build();
        db.setFirestoreSettings(settings);
        carga.setVisibility(View.VISIBLE);
        DocumentReference docRef = db.collection("cursos").document("fundaEconomia");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        carga.setVisibility(View.INVISIBLE);
                        String da =document.get("DEFINICION DE ECONOMIA").toString();
                        texto.setText(da);

                        da=document.get("laEconomiaComoCiencia").toString();
                        texto2.setText(da);
                        da=document.get("mercantilistasFisiocracia").toString();
                        texto3.setText(da);
                        da=document.get("mercantilistasFisiocracia2").toString();
                        texto4.setText(da);

                        da=document.get("economiaClasica").toString();
                        texto5.setText(da);

                        da=document.get("abstraccion").toString();
                        texto6.setText(da);
                        da=document.get("mercancia").toString();
                        texto7.setText(da);

                        da=document.get("fuerzaDeTrabajo").toString();
                        texto8.setText(da);
                    }
                }
            }
        });
    }

    public void fisic(View view){
        startActivity(new Intent(getApplicationContext(), FisicaCl.class));
        finish();
    }
    public void fundaE(View view){
        startActivity(new Intent(getApplicationContext(), FundaEconomiaCl.class));
        finish();
    }
    public  void mate(View view){
        startActivity(new Intent(getApplicationContext(), MatematicasCl.class));
        finish();
    }
    public  void consti(View view){
        startActivity(new Intent(getApplicationContext(), ConstitucionCl.class));
        finish();
    }
    public void geo(View view){
        startActivity(new Intent(getApplicationContext(), GeometriaCl.class));
        finish();
    }
    public void bio(View view){
        startActivity(new Intent(getApplicationContext(), BiologiaCl.class));
        finish();
    }
}