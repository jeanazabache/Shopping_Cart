package com.example.practicacalificadaapp;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.practicacalificadaapp.Datos.ProductoBaseHelper;
import com.example.practicacalificadaapp.Utilidades.Utilidades;

public class Registrar extends AppCompatActivity{

    private EditText edit_id;
    private EditText edit_nombre;
    private EditText edit_precio;
    private Button btn_registrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);



        edit_id = (EditText) findViewById(R.id.edit_id);
        edit_nombre = (EditText) findViewById(R.id.edit_nombre);
        edit_precio = (EditText) findViewById(R.id.edit_precio);
        btn_registrar = (Button) findViewById(R.id.btn_registrar);

        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarProducto();
            }
        });


    }

        private void registrarProducto() {
        ProductoBaseHelper conn = new ProductoBaseHelper(this,"db_producto",null,1);

        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues Values = new ContentValues();
        Values.put(Utilidades.CAMPO_ID,edit_id.getText().toString());
        Values.put(Utilidades.CAMPO_NOMBRE,edit_nombre.getText().toString());
        Values.put(Utilidades.CAMPO_PRECIO,edit_precio.getText().toString());

        Long idResultante=db.insert(Utilidades.TABLA_PRODUCTO,Utilidades.CAMPO_ID,Values);
        Toast.makeText(getApplicationContext(),"Registro"+idResultante,Toast.LENGTH_SHORT).show();
        db.close();
    }
}

