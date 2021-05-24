package com.example.practicacalificadaapp.Modelo;

public class PdtoComprado  {
    private Producto mProducto;
    private int mCantidad;

    public PdtoComprado() {
    }

    public PdtoComprado(Producto producto, int cantidad) {
        mProducto = producto;
        mCantidad = cantidad;
    }

    public Producto getProducto() {
        return mProducto;
    }

    public void setProducto(Producto producto) {
        mProducto = producto;
    }

    public int getCantidad() {
        return mCantidad;
    }

    public void setCantidad(int cantidad) {
        mCantidad = cantidad;
    }
}
