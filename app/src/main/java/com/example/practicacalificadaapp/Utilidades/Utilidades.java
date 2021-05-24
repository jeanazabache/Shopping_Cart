package com.example.practicacalificadaapp.Utilidades;

public class Utilidades {

    // Constantes campos tabla usuario
    public static final String TABLA_PRODUCTO="produto";
    public static final String CAMPO_ID="id";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_PRECIO="precio";


    public static final String CREAR_TABLA_USUARIOS = "CREATE TABLE " +
            ""+ TABLA_PRODUCTO + "("+CAMPO_ID + ""+
            "INTEGER, "+CAMPO_NOMBRE+"TEXT,"+CAMPO_PRECIO+"TEXT)";
}
