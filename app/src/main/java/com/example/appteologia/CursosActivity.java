package com.example.appteologia;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CursosActivity extends AppCompatActivity {

    private Button cursosModal;
    ImageView backModalCurso;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursos);

        dialog = new Dialog(CursosActivity.this);
        dialog.setContentView(R.layout.fragment_dialogo_cursos);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background_dialog_cursos));
        }
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;

        backModalCurso = dialog.findViewById(R.id.backModalCurso);
        backModalCurso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        cursosModal = findViewById(R.id.buttonCurosmodal);
        cursosModal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });



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

}