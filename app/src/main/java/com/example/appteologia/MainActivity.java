package com.example.appteologia;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText etLoginUser, etLoginPassword;
    Button btnLogin;
    String url = "https://juanpablo02.000webhostapp.com/crud/login.php";
    String str_email,str_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etLoginUser = findViewById(R.id.etLoginUser);
        etLoginPassword = findViewById(R.id.etLoginPassword);
        btnLogin = findViewById(R.id.btnLogin);
    }

    public void Login(View view){

        final String strUser = etLoginUser.getText().toString().trim();
        final String strPassword = etLoginPassword.getText().toString().trim();

        if(strUser.isEmpty()){
            Toast.makeText(this, "Ingrese el Usuario o Correo Electronico", Toast.LENGTH_SHORT).show();
        } else if(strPassword.isEmpty()){
            Toast.makeText(this, "Ingrese la Contraseña", Toast.LENGTH_SHORT).show();
        } else {
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Porfavor Espere...");
            progressDialog.show();

            StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://juanpablo02.000webhostapp.com/crud/login.php", new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    progressDialog.dismiss();
                    if (response.equalsIgnoreCase("Ingreso Correctamente")) {
                        startActivity(new Intent(getApplicationContext(), PrincipalActivity.class));
                        Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    progressDialog.dismiss();
                    Toast.makeText(MainActivity.this,error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
            }){
                protected Map<String, String> getParams() throws AuthFailureError{
                    Map<String,String> params = new HashMap<>();
                    params.put("usuario",etLoginUser.getText().toString());
                    params.put("password",etLoginPassword.getText().toString());

                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);
        }
    }

    /*public void validarUsuario(View view){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(!response.isEmpty()){
                    Intent intent = new Intent(getApplicationContext(),OracionActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Usuario o Contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                }
            }
            ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros= new HashMap<String, String>();
                parametros.put("usuario",etLoginUser.getText().toString());
                parametros.put("password",etLoginPassword.getText().toString());
                return parametros;
            }

        };

        RequestQueue queue = Volley.newRequestQueue( MainActivity.this);
        queue.add(stringRequest);

    }*/

    public void loginToRegister(View view){
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }

    public void loginToPrincipal(View view){
        Intent intent = new Intent(this,CursosActivity.class);
        startActivity(intent);
    }
}