package com.example.parcialcanches;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class registrarse extends AppCompatActivity {
    private EditText nombre;
    private EditText apellido;
    private Spinner genero;
    private Button Registrarse;
    private Button Volver;
    private RadioButton rbFemenino, rbMasculino;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registrarse);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        nombre = findViewById(R.id.etNombre);
        apellido = findViewById(R.id.etApellido);
        genero = findViewById(R.id.genderSpinner);
        Registrarse = findViewById(R.id.btnRegistrar);
        Volver = findViewById(R.id.btnVolver);
        rbFemenino = findViewById(R.id.rbFemenino);
        rbMasculino = findViewById(R.id.rbMasculino);

        Registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validaRegistration()) {
                    Registrar();
                }
            }
        });
        Volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Volver();
            }
        });

    }

    private boolean validaRegistration(){
        String firstName = nombre.getText().toString();
        String lastName = apellido.getText().toString();
        String gender = genero.getSelectedItem().toString();
        boolean isYesChecked = rbFemenino.isChecked();
        boolean isNoChecked = rbMasculino.isChecked();

        if(TextUtils.isEmpty(firstName)){
            nombre.setError("El campo nombre no puede estar vacío");
            return false;
        }

        if(TextUtils.isEmpty(lastName)){
            apellido.setError("El campo apellido no puede estar vacío");
            return false;
        }

        if(!isYesChecked && !isNoChecked){
            Toast.makeText(this,"Seleccione una opcion de radio", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public void Volver(){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
    public void Registrar(){
        Intent i = new Intent(this, juego.class);
        startActivity(i);
        finish();
    }
}
