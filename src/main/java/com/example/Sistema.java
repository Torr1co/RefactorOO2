package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Sistema {
	List<Cliente> clientes = new ArrayList<Cliente>();
	List<Llamada> llamadas = new ArrayList<Llamada>();
	SortedSet<String> telefonosDisponibles = new TreeSet<String>();

	public boolean agregarTelefono(String str) {
		boolean encontre = telefonosDisponibles.contains(str);
		if (!encontre) {
			telefonosDisponibles.add(str);
			encontre= true;
			return encontre;
		}
		else {
			encontre= false;
			return encontre;
		}
	}

	public Cliente registrarUsuario(Cliente nuevoCliente){
		nuevoCliente.setSistema(this);
		clientes.add(nuevoCliente);
		telefonosDisponibles.remove(nuevoCliente.getTelefono());
		return nuevoCliente;
	}

	public Cliente registrarPersonaFisica(String dni, String nombreYApellido){
		String telefono = telefonosDisponibles.last();
		Cliente nuevoCliente = new PersonaFisica(dni, nombreYApellido, telefono);
		return registrarUsuario(nuevoCliente)
	}

	public Cliente registrarPersonaJuridica(String dni, String nombreYApellido){
		String telefono = telefonosDisponibles.last();
		Cliente nuevoCliente = new PersonaJuridica(dni, nombreYApellido, telefono);
		return registrarUsuario(nuevoCliente);
	}
	
	public boolean eliminarUsuario(Cliente p) {
		List<Cliente> l = p.getSistema().clientes.stream().filter(persona -> persona != pw).collect(Collectors.toList());
		boolean borre = false;
		if (l.size() < clientes.size()) {
			this.clientes = l;
			this.telefonosDisponibles.add(p.getTelefono());
			borre = true;
		}
		return borre;
		
	}
	
	public Llamada registrarLlamada(Cliente q, Cliente q2, String t, int d) {
		Llamada x = new Llamada();
		x.tipoDeLlamada = t;
		x.setEmisor(q.getTelefono());
		x.setRemitente(q2.getTelefono());
		x.duracion= d;
		llamadas.add(x);
		q.getLlamadasRealizadas().add(x);
		return x;
		
	}
	
	public double calcularMontoTotalLlamadas(Cliente p) {
		double c = 0;
		Cliente aux = null;
		for (Cliente pp : clientes) {
			if (pp.getTelefono() == p.getTelefono()) {
				aux = pp;
				break;
			}
		} if (aux == null) return c;
		if (aux != null) {
			for (Llamada l : aux.getLlamadasRealizadas()) {
				double auxc = 0;
				if (l.tipoDeLlamada == "nacional") {
					auxc += l.duracion *3 + (l.duracion*3*0.21);
				} else if (l.tipoDeLlamada == "internacional") {
					auxc += l.duracion *200 + (l.duracion*200*0.21);
				}
				auxc -= auxc * aux.getDescuento();
				c += auxc;
			}
		}
		return c;
	}

	public int cantidadDeUsuarios() {
		return clientes.size();
	}

	public boolean existeUsuario(Cliente persona) {
		return clientes.contains(persona);
	}
	
}
