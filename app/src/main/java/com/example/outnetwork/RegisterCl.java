package com.example.outnetwork;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterCl extends AppCompatActivity {
    private EditText nombre, apellidos, usuario, correo, contra, confcontra;
    private FirebaseFirestore fStore;
    private FirebaseAuth fAuth;
    private ProgressBar progressBar;


    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_cl);
        ImageView spaceshipImage = (ImageView) findViewById(R.id.decora);
        Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(this, R.anim.recorrido);
        spaceshipImage.startAnimation(hyperspaceJumpAnimation);

        progressBar=findViewById(R.id.progreso);
        nombre=findViewById(R.id.nameEd);
        apellidos=findViewById(R.id.lastnameEd);
        usuario=findViewById(R.id.usserEd);
        correo=findViewById(R.id.emailEd);
        contra=findViewById(R.id.passwordEd);
        confcontra=findViewById(R.id.confPasswordEd);

    }
    public void enviar(View view){

        final String name=nombre.getText().toString();
        final String lastName=apellidos.getText().toString();
        final String usua=usuario.getText().toString();

        final String email=correo.getText().toString().trim();
        String password=contra.getText().toString().trim();
        String confPass=confcontra.getText().toString().trim();

        fStore=FirebaseFirestore.getInstance();
        fAuth=FirebaseAuth.getInstance();
        if(TextUtils.isEmpty(name)){
            nombre.setError(getString(R.string.campoRequerido));
        }else if(TextUtils.isEmpty(lastName)){
            apellidos.setError(getString(R.string.campoRequerido));
        }else if(TextUtils.isEmpty(usua)){
            usuario.setError(getString(R.string.campoRequerido));
        }else if (TextUtils.isEmpty(email)){
            correo.setError(getString(R.string.campoRequerido));
        }else if(TextUtils.isEmpty(password)){
            contra.setError(getString(R.string.campoRequerido));
        }else if(TextUtils.isEmpty(confPass)){
            confcontra.setError(getString(R.string.campoRequerido));
        }else if(password.length()<6){
            contra.setError(getString(R.string.contraMenor));
        }else if(password.equals(confPass)) {
            progressBar.setVisibility(View.VISIBLE);
            fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(RegisterCl.this, "Usuario registrado", Toast.LENGTH_SHORT).show();
                        userID=fAuth.getCurrentUser().getUid();
                        DocumentReference documentReference=fStore.collection("usuarios").document(userID);
                        Map<String,Object>user=new HashMap<>();
                        user.put("uNombre",name);
                        user.put("uApellido",lastName);
                        user.put("uUsser",usua);
                        user.put("uEmail",email);
                        documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("TAG","onSuccess: user Profile is created  for: "+userID);
                            }
                        });
                        progressBar.setVisibility(View.INVISIBLE);
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        finish();
                    }else{
                        progressBar.setVisibility(View.INVISIBLE);
                        Toast.makeText(RegisterCl.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }else{
            Toast.makeText(this, "Las contraseñas no coinsiden", Toast.LENGTH_SHORT).show();
        }


    }
}