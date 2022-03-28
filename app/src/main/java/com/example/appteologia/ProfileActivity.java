package com.example.appteologia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    public void perfilToHome(View view){
        Intent intent = new Intent(this,PrincipalActivity.class);
        startActivity(intent);
    }
    public void perfilToPerfil(View view){
        Intent intent = new Intent(this,CursosActivity.class);
        startActivity(intent);
    }
    public void perfilToAgenda(View view){
        Intent intent = new Intent(this,CursosActivity.class);
        startActivity(intent);
    }
    public void perfilToCursos(View view){
        Intent intent = new Intent(this,CursosActivity.class);
        startActivity(intent);
    }
    public void perfilToAgregarOracion(View view){
        Intent intent = new Intent(this,OracionActivity.class);
        startActivity(intent);
    }
}