package com.example.appteologia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class OracionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agg);
    }

    public void oracionToHome(View view){
        Intent intent = new Intent(this,PrincipalActivity.class);
        startActivity(intent);
    }
    public void oracionToPerfil(View view){
        Intent intent = new Intent(this,ProfileActivity.class);
        startActivity(intent);
    }
    public void oracionToAgenda(View view){
        Intent intent = new Intent(this,CursosActivity.class);
        startActivity(intent);
    }
    public void oracionToCursos(View view){
        Intent intent = new Intent(this,CursosActivity.class);
        startActivity(intent);
    }
    public void oracionToAgregarOracion(View view){
        Intent intent = new Intent(this,OracionActivity.class);
        startActivity(intent);
    }
}
