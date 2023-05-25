package com.example;

import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
	private  List<Llamada> llamadasRealizadas = new ArrayList<Llamada>();
	private String nombreYApellido;
	private String telefono;
	private Sistema sistema;

  public Cliente(String nombreYApellido, String telefono) {
      this.nombreYApellido = nombreYApellido;
      this.telefono = telefono;
  }

  public abstract double getDescuento();

  public List<Llamada> getLlamadasRealizadas() {
      return llamadasRealizadas;
  }

  public void setLlamadasRealizadas(List<Llamada> llamadasRealizadas) {
      this.llamadasRealizadas = llamadasRealizadas;
  }

  public String getNombreYApellido() {
      return nombreYApellido;
  }

  public void setNombreYApellido(String nombreYApellido) {
      this.nombreYApellido = nombreYApellido;
  }

  public String getTelefono() {
      return telefono;
  }

  public void setTelefono(String telefono) {
      this.telefono = telefono;
  }

  public Sistema getSistema() {
      return sistema;
  }

  public void setSistema(Sistema sistema) {
      this.sistema = sistema;
  }
  public double calcularCosteLlamadas() {
    return llamadasRealizadas.stream().mapToDouble(llamada -> llamada.calcularCosto() - (llamada.calcularCosto() * getDescuento())).sum();
  }       

  public void agregarLlamada(Llamada llamada) {
    llamadasRealizadas.add(llamada);
  }  
}