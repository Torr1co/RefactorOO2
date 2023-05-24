package com.example;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	public String nombreYApellido;
public String tipo;
public String telefono;
public String cuit;
public String dni;
public List<Llamada>llamadasRealizadas = new ArrayList<Llamada>(); ;
public Persoonal sistema;
	
	public List<Llamada> getllamadasRealizadas() {
		return llamadasRealizadas;
	}
	public void setllamadasRealizadas(List<Llamada> llamadasRealizadas) {
		this.llamadasRealizadas = llamadasRealizadas;
	}
	public String getTipo() {
		return tipo;
	}
	public void setT(String tipo) {
		this.tipo = tipo;
	}
	public String getNombreYApellido() {
		return nombreYApellido;
	}
	public void setnombreYApellido(String nombreYApellido) {
		this.nombreYApellido = nombreYApellido;
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
	

	
}
