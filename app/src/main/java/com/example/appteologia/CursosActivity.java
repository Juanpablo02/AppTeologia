package com.example.appteologia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CursosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursos);


    }

    public void CursosToHome(View view){
        Intent intent = new Intent(this,PrincipalActivity.class);
        startActivity(intent);
    }
    public void CursosToPerfil(View view){
        Intent intent = new Intent(this,ProfileActivity.class);
        startActivity(intent);
    }
    public void CursosToAgenda(View view){
        Intent intent = new Intent(this,CursosActivity.class);
        startActivity(intent);
    }
    public void CursosToCursos(View view){
        Intent intent = new Intent(this,CursosActivity.class);
        startActivity(intent);
    }
    public void CursosToAgregarOracion(View view){
        Intent intent = new Intent(this,OracionActivity.class);
        startActivity(intent);
    }

    public void cursos(View view){
        Intent intent = new Intent(this, DialogActivity.class);
        startActivity(intent);
    }
}