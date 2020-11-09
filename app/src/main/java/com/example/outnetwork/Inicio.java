package com.example.outnetwork;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Inicio extends AppCompatActivity {
    private EditText usuario,contra;
    private Button iniciar;
    private ObjectAnimator animator1,animator3,animator4;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        animacionY();

        progressBar=findViewById(R.id.progreso);
        mAuth = FirebaseAuth.getInstance();


    }
    public void animacionY(){
        iniciar=findViewById(R.id.iniciarSesion);

        usuario=findViewById(R.id.edUsuario);
        contra=findViewById(R.id.edContra);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                animator1=ObjectAnimator.ofFloat(iniciar,"y",900f);
                animator3=ObjectAnimator.ofFloat(usuario,"y",500f);
                animator4=ObjectAnimator.ofFloat(contra,"y",700f);

                animator1.setDuration(1000);
                animator3.setDuration(1000);
                animator4.setDuration(1000);

                AnimatorSet animatorSetY1= new AnimatorSet();
                AnimatorSet animatorSetY3=new AnimatorSet();
                AnimatorSet animatorSetY4=new AnimatorSet();

                animatorSetY1.play(animator1);
                animatorSetY3.play(animator3);
                animatorSetY4.play(animator4);

                animatorSetY1.start();
                animatorSetY3.start();
                animatorSetY4.start();
            }
        }, 600);

    }
    public void register(View view){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if(networkInfo==null){
            Toast.makeText(this,"No tienes conexion te recomendamos entrar como invitado",Toast.LENGTH_SHORT).show();
        }else {
            Intent intent = new Intent(Inicio.this, RegisterCl.class);
            startActivity(intent);
        }
    }
    public void login(View view){
        String email=usuario.getText().toString().trim();
        String password=contra.getText().toString().trim();
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        progressBar.setVisibility(View.VISIBLE);
        if (networkInfo == null){
            Toast.makeText(this,"No tienes conexion te recomendamos entrar como invitado",Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.INVISIBLE);
        }else {
            if(TextUtils.isEmpty(email)){
                usuario.setError(getString(R.string.campoRequerido));
                progressBar.setVisibility(View.INVISIBLE);
            }else if(TextUtils.isEmpty(password)){
                contra.setError(getString(R.string.campoRequerido));
                progressBar.setVisibility(View.INVISIBLE);
            }else{
                progressBar.setVisibility(View.VISIBLE);
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Inicio.this, "Bienvenido", Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.INVISIBLE);
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        } else {
                            progressBar.setVisibility(View.INVISIBLE);
                            Toast.makeText(Inicio.this, "Lo sentimos verifique sus datos", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }

    }
    public void invitado(View view){
        Intent intent =new Intent(Inicio.this, MainActivity.class);
        startActivity(intent);
    }



}