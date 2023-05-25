package com.example;

public class PersonaJuridica extends Cliente {
    private String cuit;
    private static final double DESCUENTO_JURIDICA = 0.15;
    
    public PersonaJuridica(String cuit, String nombreYApellido, String telefono) {
        super(nombreYApellido, telefono);
        this.cuit = cuit;
    }
    
    public double getDescuento(){
        return DESCUENTO_JURIDICA;
    }
}