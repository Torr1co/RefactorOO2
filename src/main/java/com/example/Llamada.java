package com.example;

public class Llamada {
    protected String tipoDeLlamada;
    private String emisor;
    private String remitente;
    public int dur;

    public Llamada() {
        
    }
    public Llamada(String tipoDeLlamada, String emisor, String remitente, int dur) {
        this.tipoDeLlamada = tipoDeLlamada;
        this.emisor = emisor;
        this.remitente = remitente;
        this.dur = dur;
    }

    public String getTipoDeLlamada() {
        return tipoDeLlamada;
    }

    public void setTipoDeLlamada(String tipoDeLlamada) {
        this.tipoDeLlamada = tipoDeLlamada;
    }
    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }
    public String getRemitente() {
        return remitente;
    }
    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public double calcularCosto() {
        double costo = 0;
        if (tipoDeLlamada.equals("nacional")) {
            costo = dur * 3 + (dur * 3 * 0.21);
        } else if (tipoDeLlamada.equals("internacional")) {
            costo = dur * 200 + (dur * 200 * 0.21);
        }
        return costo;
    }
}
