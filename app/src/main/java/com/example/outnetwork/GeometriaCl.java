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

public class GeometriaCl extends AppCompatActivity {
    private TextView texto,carga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geometria_cl);
        texto=findViewById(R.id.texto);
        carga=findViewById(R.id.carga1);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build();
        db.setFirestoreSettings(settings);
        carga.setVisibility(View.VISIBLE);
        DocumentReference docRef = db.collection("cursos").document("geometria");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        carga.setVisibility(View.INVISIBLE);
                        String da =document.get("definicion").toString();
                        texto.setText(da);
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