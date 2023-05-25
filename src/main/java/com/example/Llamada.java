package com.example;

public abstract class Llamada {
    protected int duracion;
    private String emisor;
    private String remitente;
    protected static final double PORCENTAJE_IVA = 0.21;

    public Llamada(int duracion, String emisor, String remitente) {
        this.duracion = duracion;
        this.emisor = emisor;
        this.remitente = remitente;
    }
    
    public abstract double calcularCosto();
}
