package com.example.practicacalificadaapp.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practicacalificadaapp.Control.MainActivity;
import com.example.practicacalificadaapp.Modelo.PdtoComprado;
import com.example.practicacalificadaapp.R;

import java.util.ArrayList;

public class CheckoutFragment extends Fragment {

    private ArrayList<PdtoComprado> mPdtoComprados;
    private String precioTotal;
    private Button btnConfirmar;
    private Button btnCancelar;
    private TextView mTotal;
    private View root_view;

    public CheckoutFragment() {
        // Required empty public constructor
    }


    public static CheckoutFragment newInstance(String param1, String param2) {
        CheckoutFragment fragment = new CheckoutFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root_view  =inflater.inflate(R.layout.fragment_checkout, container, false);

        precioTotal =  "0"; //getIntent().getStringExtra("carrito");

        mTotal = (TextView) root_view.findViewById(R.id.txt_total);
        mTotal.setText(precioTotal);

        btnConfirmar = (Button) root_view.findViewById(R.id.btn_confirmar);
        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getContext(),"Compra confirmada",Toast.LENGTH_SHORT).show();

            }
        });

        btnCancelar = (Button) root_view.findViewById(R.id.btn_cancelar);
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);

            }
        });

        return  root_view;
    }
}