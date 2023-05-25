package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Sistema {
	List<Cliente> clientes = new ArrayList<Cliente>();
	List<Llamada> llamadas = new ArrayList<Llamada>();
	SortedSet<String> telefonosDisponibles = new TreeSet<String>();


	public boolean agregarTelefono(String telefono) {
		return telefonosDisponibles.add(telefono);
	}

	public Cliente registrarUsuario(String identificacion, String nombreYApellido, String tipo) {
		Cliente cliente; 
		String telefonoDisponible = telefonosDisponibles.last();
		if (tipo.equals("fisica")) {
			cliente = new PersonaFisica(identificacion,nombreYApellido,telefonoDisponible);
		} else if (tipo.equals("juridica")) {
			cliente = new PersonaJuridica(identificacion,nombreYApellido,telefonoDisponible);
		}
		else {
			return null;
		}
		telefonosDisponibles.remove(telefonoDisponible);
		cliente.setSistema(this);
		clientes.add(cliente);
		return cliente;
	  }
	
	public Llamada registrarLlamada(Cliente clienteEmisor, Cliente clienteReceptor, String tipo, int duracion) {
		Llamada nuevaLlamada;
		if (tipo.equals("nacional")) {
			nuevaLlamada = new LlamadaNacional(duracion, clienteEmisor.getTelefono(), clienteReceptor.getTelefono());
		} else if (tipo.equals("internacional")) {
			nuevaLlamada = new LlamadaInternacional(duracion, clienteEmisor.getTelefono(), clienteReceptor.getTelefono());
		} else {
			return null;
		}
		llamadas.add(nuevaLlamada);
		clienteEmisor.agregarLlamada(nuevaLlamada);
		return nuevaLlamada;
	}
	
	public double calcularMontoTotalLlamadas(Cliente cliente) {
		double montoTotal = 0;
		if (clientes.contains(cliente)) {
			montoTotal = cliente.calcularCosteLlamadas();
		}
		return montoTotal;
	}
	  
	public boolean eliminarUsuario(Cliente cliente) {
		return clientes.remove(cliente);
	}

	public int cantidadDeUsuarios() {
		return clientes.size();
	}

	public boolean existeUsuario(Cliente cliente ) {
		return clientes.contains(cliente);
	}
	
}
