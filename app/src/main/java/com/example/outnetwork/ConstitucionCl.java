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

public class ConstitucionCl extends AppCompatActivity {
    private TextView texto,texto2,texto3,texto4,texto5,texto6,texto7,texto8
            ,texto9, texto10, texto11, texto12, texto13,carga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constitucion_cl);
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
        carga=findViewById(R.id.carga1);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        carga.setVisibility(View.VISIBLE);
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build();
        db.setFirestoreSettings(settings);
        DocumentReference docRef = db.collection("cursos").document("constitucionDemocracia");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        carga.setVisibility(View.INVISIBLE);
                        String da =document.get("definicionEstado").toString();
                        texto.setText(da);

                        da=document.get("territorio").toString();
                        texto2.setText(da);
                        da=document.get("poblacion").toString();
                        texto3.setText(da);
                        da=document.get("gobierno").toString();
                        texto4.setText(da);

                        da=document.get("soberania").toString();
                        texto5.setText(da);

                        da=document.get("coercion").toString();
                        texto6.setText(da);
                        da=document.get("poderEjecutivo").toString();
                        texto7.setText(da);

                        da=document.get("poderLegislativo").toString();
                        texto8.setText(da);

                        da =document.get("poderJudicial").toString();
                        texto9.setText(da);

                        da=document.get("constitucion").toString();
                        texto10.setText(da);
                        da=document.get("principiosConsti").toString();
                        texto11.setText(da);
                        da=document.get("derechosHumanos").toString();
                        texto12.setText(da);

                        da=document.get("derechosFundamentales").toString();
                        texto13.setText(da);
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