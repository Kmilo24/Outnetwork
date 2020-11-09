package com.example.outnetwork;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animacion();
    }
    public void animacion(){
        ImageView spaceshipImage = (ImageView) findViewById(R.id.encabezado);
        Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(this, R.anim.recorrido);
        spaceshipImage.startAnimation(hyperspaceJumpAnimation);
    }
    public void fundaEconomia(View view){
        startActivity(new Intent(getApplicationContext(), FundaEconomiaCl.class));
    }
    public void fisi(View view){
        startActivity(new Intent(getApplicationContext(), FisicaCl.class));
    }
    public  void mate(View view){
        startActivity(new Intent(getApplicationContext(), MatematicasCl.class));
    }
    public  void consti(View view){
        startActivity(new Intent(getApplicationContext(), ConstitucionCl.class));
    }
    public void geo(View view){
        startActivity(new Intent(getApplicationContext(), GeometriaCl.class));
    }
    public void bio(View view){
        startActivity(new Intent(getApplicationContext(), BiologiaCl.class));
    }
    public void perfil(View view){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo == null){
            Toast.makeText(this,"No tienes conexion",Toast.LENGTH_SHORT).show();
        }else {
            startActivity(new Intent(getApplicationContext(), Perfil.class));
        }
    }
}