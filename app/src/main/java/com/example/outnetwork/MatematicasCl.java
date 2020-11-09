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

public class MatematicasCl extends AppCompatActivity {
    private TextView texto,texto2,texto3,texto4,texto5,texto6,texto7,texto8
            ,texto9, texto10, texto11, texto12, texto13, texto14, texto15, texto16,
            texto17,texto18,texto19,texto20,carga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matematicas_cl);
        texto=findViewById(R.id.texto);
        texto2=findViewById(R.id.texto2);
        texto3=findViewById(R.id.texto3);
        texto4=findViewById(R.id.texto4);
        texto5=findViewById(R.id.texto5);
        texto6=findViewById(R.id.texto6);
        texto7=findViewById(R.id.texto7);
        texto8=findViewById(R.id.texto8);
        texto9=findViewById(R.id.texto9);
        texto10=findViewById(R.id.texto10);
        texto11=findViewById(R.id.texto11);
        texto12=findViewById(R.id.texto12);
        texto13=findViewById(R.id.texto13);
        texto14=findViewById(R.id.texto14);
        texto15=findViewById(R.id.texto15);
        texto16=findViewById(R.id.texto16);
        texto17=findViewById(R.id.texto17);
        texto18=findViewById(R.id.texto18);
        texto19=findViewById(R.id.texto19);
        texto20=findViewById(R.id.texto20);
        carga=findViewById(R.id.carga1);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build();
        db.setFirestoreSettings(settings);
        carga.setVisibility(View.VISIBLE);
        DocumentReference docRef = db.collection("cursos").document("matematicas");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        carga.setVisibility(View.INVISIBLE);
                        String da =document.get("queSonLosNumeros").toString();
                        texto.setText(da);
                        da =document.get("suma").toString();
                        texto2.setText(da);
                        da =document.get("resta").toString();
                        texto3.setText(da);
                        da =document.get("multiplicacion").toString();
                        texto4.setText(da);
                        da =document.get("division").toString();
                        texto5.setText(da);

                        da =document.get("numeroscomplejos").toString();
                        texto6.setText(da);

                        da=document.get("sumaC").toString();
                        texto7.setText(da);
                        da=document.get("restaC").toString();
                        texto8.setText(da);
                        da=document.get("multiplicacionC").toString();
                        texto9.setText(da);

                        da=document.get("regla1").toString();
                        texto10.setText(da);

                        da=document.get("regla2").toString();
                        texto11.setText(da);
                        da=document.get("regla3").toString();
                        texto12.setText(da);

                        da=document.get("regla4").toString();
                        texto13.setText(da);

                        da =document.get("regla5").toString();
                        texto14.setText(da);

                        da=document.get("ejemploMC1").toString();
                        texto15.setText(da);
                        da=document.get("ejemploMC2").toString();
                        texto16.setText(da);
                        da=document.get("ejemploMC3").toString();
                        texto17.setText(da);

                        da=document.get("divisionC").toString();
                        texto18.setText(da);

                        da=document.get("ejemploD1").toString();
                        texto19.setText(da);
                        da=document.get("ejemploD2").toString();
                        texto20.setText(da);
                    }
                }
            }
        });
    }


    public void fisi(View view){
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