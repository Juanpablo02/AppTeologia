package com.example.appteologia;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.CursorLoader;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    EditText etName, etLastName, etEmail, etTelefono, etPassword, etConfirmPassword, etUser;
    Button btnRegister;

    final String url = "http://172.23.2.78/servicios/register.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etName = findViewById(R.id.etName);
        etLastName = findViewById(R.id.etLastName);
        etEmail = findViewById(R.id.etEmail);
        etTelefono = findViewById(R.id.etTelefono);
        etUser = findViewById(R.id.etUser);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ejecutarServicio();
            }
        });
    }
    /*
    private void insertarDatos() {
        final String name = etName.getText().toString().trim();
        final String lastName = etLastName.getText().toString().trim();
        final String email = etEmail.getText().toString().trim();
        final String telefono = etTelefono.getText().toString().trim();
        final String user = etUser.getText().toString().trim();
        final String password = etPassword.getText().toString().trim();

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Cargando");

        if (name.isEmpty()) {
            Toast.makeText(this, "Ingrese el nombre", Toast.LENGTH_SHORT).show();
            return;
        } else if (lastName.isEmpty()) {
            Toast.makeText(this, "Ingrese el Apellido", Toast.LENGTH_SHORT).show();
            return;
        } else if (email.isEmpty()) {
            Toast.makeText(this, "Ingrese el email", Toast.LENGTH_SHORT).show();
            return;
        } else if (telefono.isEmpty()) {
            Toast.makeText(this, "Ingrese el telefono", Toast.LENGTH_SHORT).show();
            return;
        } else if (user.isEmpty()) {
            Toast.makeText(this, "Ingrese el nombre de Usuario", Toast.LENGTH_SHORT).show();
            return;
        } else if (password.isEmpty()) {
            Toast.makeText(this, "Ingrese la contraseña", Toast.LENGTH_SHORT).show();
            return;
        } else {
            progressDialog.show();
            StringRequest request = new StringRequest(Request.Method.POST, "https://juanpablo02.000webhostapp.com/crud/register.php", new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if (response.equalsIgnoreCase("Datos Insertados")) {
                        Toast.makeText(RegisterActivity.this, "Datos Insertados", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();

                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();
                    } else {
                        Toast.makeText(RegisterActivity.this,"hola"+ response, Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(RegisterActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }) {
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();

                    params.put("nombre", name);
                    params.put("apellido", lastName);
                    params.put("email", email);
                    params.put("telefono", telefono);
                    params.put("usuario", user);
                    params.put("contraseña", password);

                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(RegisterActivity.this);
            requestQueue.add(request);
        }
    }

    public void onBackPressed(){
        super.onBackPressed();
        finish();
    }
    */

    private void ejecutarServicio() {
        final String name = etName.getText().toString().trim();
        final String lastName = etLastName.getText().toString().trim();
        final String email = etEmail.getText().toString().trim();
        final String telefono = etTelefono.getText().toString().trim();
        final String user = etUser.getText().toString().trim();
        final String password = etPassword.getText().toString().trim();
        final String confirmPassword = etConfirmPassword.getText().toString().trim();

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Cargando");

        if (user.isEmpty() || user.length() > 20) {
            Toast.makeText(this, "Ingrese el nombre de Usuario", Toast.LENGTH_SHORT).show();
            return;
        } else if (name.isEmpty() || name.length() > 50) {
            Toast.makeText(this, "Ingrese el nombre", Toast.LENGTH_SHORT).show();
            return;
        } else if (lastName.isEmpty() || lastName.length() > 50) {
            Toast.makeText(this, "Ingrese el Apellido", Toast.LENGTH_SHORT).show();
            return;
        } else if (email.isEmpty() || email.length() > 50) {
            Toast.makeText(this, "Ingrese el email", Toast.LENGTH_SHORT).show();
            return;
        } else if (telefono.isEmpty() || telefono.length() > 12) {
            Toast.makeText(this, "Ingrese el telefono", Toast.LENGTH_SHORT).show();
            return;
        } else if (password.isEmpty() || password.length() > 20) {
            Toast.makeText(this, "Ingrese la contraseña", Toast.LENGTH_SHORT).show();
            return;
        } else if (confirmPassword.isEmpty()){
            Toast.makeText(this, "Ingrese la confirmacion de contraseña", Toast.LENGTH_SHORT).show();
        } else if(confirmPassword.equals(password)) {
            progressDialog.show();
            StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://juanpablo02.000webhostapp.com/crud/register.php", new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Toast.makeText(getApplicationContext(), "Registro Exitoso", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> parametros = new HashMap<String, String>();
                    parametros.put("nombre", etName.getText().toString());
                    parametros.put("apellido", etLastName.getText().toString());
                    parametros.put("email", etEmail.getText().toString());
                    parametros.put("telefono", etTelefono.getText().toString());
                    parametros.put("usuario", etUser.getText().toString());
                    parametros.put("contraseña", etPassword.getText().toString());

                    return parametros;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);
        } else {
            Toast.makeText(this, "Las contraseñas deben coincidir", Toast.LENGTH_SHORT).show();
        }
    }
}
