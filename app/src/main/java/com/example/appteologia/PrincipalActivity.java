package com.example.appteologia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    public void PrincipalToMain(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void PrincipalToOracion(View view){
        Intent intent = new Intent(this,OracionActivity.class);
        startActivity(intent);
    }

    public void PrincipalToCursos(View view){
        Intent intent = new Intent(this,CursosActivity.class);
        startActivity(intent);
    }
}