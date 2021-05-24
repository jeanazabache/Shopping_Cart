package com.example.practicacalificadaapp.Modelo;

public class Producto {
    public String mNombre;
    public double mPrecio;

    public Producto(String nombre, double precio) {
        mNombre = nombre;
        mPrecio = precio;
    }

    public String getNombre() {
        return mNombre;
    }

    public void setNombre(String nombre) {
        mNombre = nombre;
    }

    public double getPrecio() {
        return mPrecio;
    }

    public void setPrecio(double precio) {
        mPrecio = precio;
    }
    @Override
    public String toString() {
        return getNombre();
    }
}
