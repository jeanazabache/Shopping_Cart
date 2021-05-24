package com.example.practicacalificadaapp.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.practicacalificadaapp.Control.CheckOutActivity;
import com.example.practicacalificadaapp.Modelo.PdtoComprado;
import com.example.practicacalificadaapp.Modelo.Producto;
import com.example.practicacalificadaapp.R;

import java.util.ArrayList;
import java.util.List;


public class CarritoFragment extends Fragment {

    private EditText edtCantidad;
    private Spinner spProducto;
    private Button btnAgregar;
    private Button btnComprar;
    private Button btnSQL;
    private List<PdtoComprado> mCarrito = new ArrayList<>();
    private double precioTotal =0.0;
    private View root_view;

    private Producto[] listProducto = new Producto[]{
            new Producto("Galleta",1.2),
            new Producto("Gaseosa",1.8),
            new Producto("Arroz",3.1),
            new Producto("Azucar",10.6),
            new Producto("Jabon",0.9),
            new Producto("Detergente",5.2),
    };

    public CarritoFragment() {
        // Required empty public constructor
    }


    public static CarritoFragment newInstance(String param1, String param2) {
        CarritoFragment fragment = new CarritoFragment();
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
        root_view  =inflater.inflate(R.layout.fragment_carrito, container, false);

        edtCantidad = (EditText) root_view.findViewById(R.id.edit_cantidad);
        spProducto = (Spinner) root_view.findViewById(R.id.sp_productos);
        btnAgregar = (Button) root_view.findViewById(R.id.btn_agregar);
        btnComprar = (Button) root_view.findViewById(R.id.btn_comprar);
        btnSQL = (Button) root_view.findViewById(R.id.btn_SQL);

        ArrayAdapter<Producto> adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item, listProducto);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spProducto.setAdapter(adapter);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(edtCantidad.getText().toString().equals("") || Integer.parseInt(edtCantidad.getText().toString()) <= 0 ){
                    Toast.makeText(getContext(),"Ingrese una cantidad válida",Toast.LENGTH_SHORT).show();
                }else {
                    Producto item = (Producto) spProducto.getSelectedItem();
                    int cant = Integer.parseInt(edtCantidad.getText().toString());

                    Log.i("INFO","Producto"+item.getNombre()+"Cantidad"+ cant);

                    PdtoComprado pdtoComprado = new PdtoComprado();
                    pdtoComprado.setProducto(item);
                    pdtoComprado.setCantidad(cant);

                    mCarrito.add(pdtoComprado);

                    edtCantidad.setText("");
                    Toast.makeText(getContext(),"Agregado",Toast.LENGTH_SHORT).show();

                }
            }
        });

        btnComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (PdtoComprado prod :mCarrito) {
                    precioTotal = precioTotal + prod.getCantidad() * prod.getProducto().getPrecio();
                }



                Intent intent = new Intent(getContext(), CheckOutActivity.class);
                intent.putExtra("carrito",""+precioTotal);
                startActivity(intent);
            }
        });

//        btnSQL.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent( MainActivity.this, Registrar.class);
//                startActivity(i);
//            }
//        });



        return  root_view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }


}