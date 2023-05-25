package com.example;

public class LlamadaInternacional extends Llamada{
    private static final double PRECIO_X_MINUTO = 200;
    public LlamadaInternacional(int duracion, String emisor, String remitente) {
        super(duracion, emisor, remitente);
    }

    @Override
    public double calcularCosto() {
        double costo = duracion * PRECIO_X_MINUTO + (duracion * PRECIO_X_MINUTO * PORCENTAJE_IVA);
        return costo;
    }
}
