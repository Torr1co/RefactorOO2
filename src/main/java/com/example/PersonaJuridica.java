package com.example;

public class PersonaJuridica extends Cliente {
    private String cuit;
    static double descuentoJur = 0.15;
    
    public PersonaJuridica(String cuit, String nombreYApellido, String telefono) {
        super(nombreYApellido, telefono);
        this.cuit = cuit;
    }

    public String getCuit() {
        return cuit;
    }
    
    public double getDescuento(){
        return descuentoJur;
    }
}