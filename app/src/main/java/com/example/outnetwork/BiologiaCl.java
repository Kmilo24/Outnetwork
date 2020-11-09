package com.example.outnetwork;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;

public class BiologiaCl extends AppCompatActivity {
    private TextView texto,texto2,texto3,texto4,texto5,texto6,texto7,texto8
            ,texto9, texto10, texto11, texto12, texto13, texto14,carga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biologia_cl);
        texto=findViewById(R.id.texto);
        carga=findViewById(R.id.carga1);
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
        carga.setVisibility(View.VISIBLE);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build();
        db.setFirestoreSettings(settings);
        DocumentReference docRef = db.collection("cursos").document("biologia");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        carga.setVisibility(View.INVISIBLE);
                        String da =document.get("definicion").toString();
                        texto.setText(da);
                        da=document.get("celula").toString();
                        texto2.setText(da);
                        da=document.get("eucariotas").toString();
                        texto3.setText(da);
                        da=document.get("procariotas").toString();
                        texto4.setText(da);

                        da=document.get("clasificacionOrganismos").toString();
                        texto5.setText(da);

                        da=document.get("unicelulares").toString();
                        texto6.setText(da);
                        da=document.get("pluricelulares").toString();
                        texto7.setText(da);

                        da=document.get("funcionCelula").toString();
                        texto8.setText(da);

                        da =document.get("relacion").toString();
                        texto9.setText(da);

                        da=document.get("reproduccion").toString();
                        texto10.setText(da);
                        da=document.get("nutricion").toString();
                        texto11.setText(da);
                        da=document.get("membrana").toString();
                        texto12.setText(da);

                        da=document.get("citoplasma").toString();
                        texto13.setText(da);

                        da=document.get("nucleoCelular").toString();
                        texto14.setText(da);
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