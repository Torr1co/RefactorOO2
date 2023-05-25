package com.example;

public class PersonaFisica  extends Cliente{
    private String dni; 
    private static final double DESCUENTO_FISICA = 0;

    public PersonaFisica(String dni, String nombreYApellido, String telefono) {
        super(nombreYApellido, telefono);
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public double getDescuento(){
        return DESCUENTO_FISICA;
    }
}
