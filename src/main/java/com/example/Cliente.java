package com.example;

import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
	private  List<Llamada> llamadasRealizadas = new ArrayList<Llamada>();
	private String nombreYApellido;
	private String telefono;

  public Cliente(String nombreYApellido, String telefono) {
      this.nombreYApellido = nombreYApellido;
      this.telefono = telefono;
  }

  public abstract double getDescuento();

  public String getTelefono() {
      return telefono;
  }

  public double calcularCosteLlamadas() {
    return llamadasRealizadas.stream().mapToDouble(llamada -> llamada.calcularCosto() - (llamada.calcularCosto() * getDescuento())).sum();
  }       

  public void agregarLlamada(Llamada llamada) {
    llamadasRealizadas.add(llamada);
  }  
}