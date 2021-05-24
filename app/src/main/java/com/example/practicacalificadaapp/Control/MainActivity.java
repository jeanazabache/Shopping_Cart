package com.example.practicacalificadaapp.Control;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Region;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.practicacalificadaapp.Fragment.CarritoFragment;
import com.example.practicacalificadaapp.Fragment.CheckoutFragment;
import com.example.practicacalificadaapp.Modelo.PdtoComprado;
import com.example.practicacalificadaapp.Modelo.Producto;
import com.example.practicacalificadaapp.Datos.ProductoBaseHelper;
import com.example.practicacalificadaapp.R;
import com.example.practicacalificadaapp.Registrar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
//
//    private EditText edtCantidad;
//    private Spinner spProducto;
//    private Button btnAgregar;
//    private Button btnComprar;
//    private Button btnSQL;
//    private List<PdtoComprado> mCarrito = new ArrayList<>();
//    private double precioTotal =0.0;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;


    private Button btnCarrito;
    private Button btnCheckout;

//    private Producto[] listProducto = new Producto[]{
//            new Producto("Galleta",1.2),
//            new Producto("Gaseosa",1.8),
//            new Producto("Arroz",3.1),
//            new Producto("Azucar",10.6),
//            new Producto("Jabon",0.9),
//            new Producto("Detergente",5.2),
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);



//        ProductoBaseHelper conn= new ProductoBaseHelper(this,"bd_producto",null,1);
//
//        edtCantidad = (EditText) findViewById(R.id.edit_cantidad);
//        spProducto = (Spinner) findViewById(R.id.sp_productos);
//        btnAgregar = (Button) findViewById(R.id.btn_agregar);
//        btnComprar = (Button) findViewById(R.id.btn_comprar);
//        btnSQL = (Button) findViewById(R.id.btn_SQL);

        btnCarrito = (Button) findViewById(R.id.btn_carrito);
        btnCheckout = (Button) findViewById(R.id.btn_checkout);

//        ArrayAdapter<Producto> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, listProducto);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spProducto.setAdapter(adapter);
//
//        btnAgregar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if(edtCantidad.getText().toString().equals("") || Integer.parseInt(edtCantidad.getText().toString()) <= 0 ){
//                    Toast.makeText(getApplicationContext(),"Ingrese una cantidad válida",Toast.LENGTH_SHORT).show();
//                }else {
//                    Producto item = (Producto) spProducto.getSelectedItem();
//                    int cant = Integer.parseInt(edtCantidad.getText().toString());
//
//                    Log.i("INFO","Producto"+item.getNombre()+"Cantidad"+ cant);
//
//                    PdtoComprado pdtoComprado = new PdtoComprado();
//                    pdtoComprado.setProducto(item);
//                    pdtoComprado.setCantidad(cant);
//
//                    mCarrito.add(pdtoComprado);
//
//                    edtCantidad.setText("");
//                    Toast.makeText(getApplicationContext(),"Agregado",Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        });

//        btnComprar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                for (PdtoComprado prod :mCarrito) {
//                    precioTotal = precioTotal + prod.getCantidad() * prod.getProducto().getPrecio();
////                    Log.i("INFO ","Producto "+prod.getProducto().getNombre()+" Cantidad "+prod.getCantidad());
//                }
//
//                Intent intent = new Intent(getApplicationContext(),CheckOutActivity.class);
//                intent.putExtra("carrito",""+precioTotal);
//                startActivity(intent);
//            }
//        });
//
//        btnSQL.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            Intent i = new Intent( MainActivity.this,Registrar.class);
//            startActivity(i);
//            }
//        });

        btnCarrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                CarritoFragment carritoFragment = new CarritoFragment();
                fragmentTransaction.replace(R.id.content_fragment,carritoFragment,CarritoFragment.class.getName());
                fragmentTransaction.commit();

            }
        });

        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                CheckoutFragment checkoutFragment = new CheckoutFragment();
                fragmentTransaction.replace(R.id.content_fragment,checkoutFragment,CheckoutFragment.class.getName());
                fragmentTransaction.commit();

            }
        });

    }
}