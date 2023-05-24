package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sistema {
	List<Cliente> clientes = new ArrayList<Cliente>();
	List<Llamada> llamadas = new ArrayList<Llamada>();
	GuiaTelefonica telefonosDisponibles = new GuiaTelefonica();
	
	public boolean agregarTelefono(String str) {
		boolean encontre = telefonosDisponibles.guia.contains(str);
		if (!encontre) {
			telefonosDisponibles.guia.add(str);
			encontre= true;
			return encontre;
		}
		else {
			encontre= false;
			return encontre;
		}
	}
	
	public Cliente registrarUsuario(String data, String nombre, String t) {
		Cliente var = new Cliente();
		if (t.equals("fisica")) {
			var.setNombreYApellido(nombre);
			String tel = telefonosDisponibles.guia.last();
			telefonosDisponibles.guia.remove(tel);
			var.setTipo(t);
			var.setTelefono(tel);
			var.setDni(data);
		}
		else if (t.equals("juridica")) {
			String tel = telefonosDisponibles.guia.last();
			telefonosDisponibles.guia.remove(tel);
			var.setNombreYApellido(nombre);
			var.setTipo(t);
			var.setTelefono(tel);
			var.setDni(data);
		}
		var.setSistema(this);;
		clientes.add(var);
		return var;
	}
	
	public boolean eliminarUsuario(Cliente p) {
		List<Cliente> l = p.getSistema().clientes.stream().filter(persona -> persona != p).collect(Collectors.toList());
		boolean borre = false;
		if (l.size() < clientes.size()) {
			this.clientes = l;
			this.telefonosDisponibles.guia.add(p.getTelefono());
			borre = true;
		}
		return borre;
		
	}
	
	public Llamada registrarLlamada(Cliente q, Cliente q2, String t, int d) {
		Llamada x = new Llamada();
		x.tipoDeLlamada = t;
		x.setEmisor(q.getTelefono());
		x.setRemitente(q2.getTelefono());
		x.dur= d;
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
					auxc += l.dur *3 + (l.dur*3*0.21);
				} else if (l.tipoDeLlamada == "internacional") {
					auxc += l.dur *200 + (l.dur*200*0.21);
				}
				
				if (aux.getTipo() == "fisica") {
					auxc -= auxc*aux.getDescuentoFisico();
				} else if(aux.getTipo() == "juridica") {
					auxc -= auxc*aux.getDescuentoJuridico();
				}
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
