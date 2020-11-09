package com.example.outnetwork;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class Perfil extends AppCompatActivity {
    private TextView nombre, apellidos,usuario,correo;
    private FirebaseAuth fAuth;
    private FirebaseFirestore fStore;
    private String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        nombre=findViewById(R.id.nombre);
        apellidos=findViewById(R.id.apellidos);
        usuario=findViewById(R.id.usuario);
        correo=findViewById(R.id.correo);
        fAuth=FirebaseAuth.getInstance();
        fStore=FirebaseFirestore.getInstance();
        id=fAuth.getCurrentUser().getUid();
        final DocumentReference documentReference=fStore.collection("usuarios").document(id);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                nombre.setText(documentSnapshot.getString("uNombre"));
                apellidos.setText(documentSnapshot.getString("uApellido"));
                usuario.setText(documentSnapshot.getString("uUsser"));
                correo.setText(documentSnapshot.getString("uEmail"));
            }
        });
    }
    public void cerrar(View view){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), Inicio.class));
        finish();
    }
}