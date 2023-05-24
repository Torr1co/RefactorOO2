package com.example;

public class Llamada {
	private String emisor;
    private String tipoDeLlamada;
    private String remitente;
    private int duracion;

    public Llamada() {
        
    }
    public Llamada(String tipoDeLlamada, String emisor, String remitente, int duracion) {
        this.tipoDeLlamada = tipoDeLlamada;
        this.emisor = emisor;
        this.remitente = remitente;
        this.duracion = duracion;
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

	public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public double calcularCosto() {
        double costo = 0;
        if (tipoDeLlamada.equals("nacional")) {
            costo = duracion * 3 + (duracion * 3 * 0.21);
        } else if (tipoDeLlamada.equals("internacional")) {
            costo = duracion * 200 + (duracion * 200 * 0.21);
        }
        return costo;
    }
}
