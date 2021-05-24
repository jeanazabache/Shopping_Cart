package com.example.practicacalificadaapp.Control;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.example.practicacalificadaapp.Modelo.PdtoComprado;
import com.example.practicacalificadaapp.R;

import java.util.ArrayList;

public class CheckOutActivity extends AppCompatActivity {


    private ArrayList<PdtoComprado> mPdtoComprados;
    private String precioTotal;
    private Button btnConfirmar;
    private Button btnCancelar;
    private TextView mTotal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);
        precioTotal =  getIntent().getStringExtra("carrito");

        mTotal = (TextView) findViewById(R.id.txt_total);
        mTotal.setText(precioTotal);

        btnConfirmar = (Button) findViewById(R.id.btn_confirmar);
        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"Compra confirmada",Toast.LENGTH_SHORT).show();

            }
        });

        btnCancelar = (Button) findViewById(R.id.btn_cancelar);
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }
        });


    }

}