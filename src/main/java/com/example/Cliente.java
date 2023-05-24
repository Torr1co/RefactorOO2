package com.example;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private String nombreYApellido;
private String tipo;
private String telefono;
private String cuit;
private String dni;
private List<Llamada>llamadasRealizadas = new ArrayList<Llamada>(); ;
private Persoonal sistema;

public String getNombreYApellido() {
    return nombreYApellido;
}

public void setNombreYApellido(String nombreYApellido) {
    this.nombreYApellido = nombreYApellido;
}

public String getTipo() {
    return tipo;
}

public void setTipo(String tipo) {
    this.tipo = tipo;
}

public String getTelefono() {
    return telefono;
}

public void setTelefono(String telefono) {
    this.telefono = telefono;
}

public String getCuit() {
    return cuit;
}

public void setCuit(String cuit) {
    this.cuit = cuit;
}

public String getDni() {
    return dni;
}

public void setDni(String dni) {
    this.dni = dni;
}

public ArrayList<Llamada> getLlamadasRealizadas() {
    return llamadasRealizadas;
}

public void setLlamadasRealizadas(ArrayList<Llamada> llamadasRealizadas) {
    this.llamadasRealizadas = llamadasRealizadas;
}

public Persoonal getSistema() {
    return sistema;
}

public void setSistema(Persoonal sistema) {
    this.sistema = sistema;
}

}
