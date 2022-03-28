package com.example.appteologia.dialogos;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.appteologia.CursosActivity;
import com.example.appteologia.R;
import com.example.appteologia.RegisterActivity;


public class DialogoCursosFragment extends DialogFragment {

    Activity activity;
    ImageView btnSalir;
    LinearLayout barraSuperior;
    TextView aceptar;


    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater= requireActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.fragment_dialogo_cursos,null));

        return builder.create();
    }

    private AlertDialog crearDialogoGestionar(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_dialogo_cursos,null);
        builder.setView(view);

        barraSuperior.findViewById(R.id.barraSuperior);
        btnSalir.findViewById(R.id.imageView14);

        eventosBotones();

        return builder.create();
    }

    private void eventosBotones(){
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if (context instanceof Activity){
            this.activity = (Activity) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

}