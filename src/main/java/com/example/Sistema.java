package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sistema {
	List<Cliente> lista1 = new ArrayList<Cliente>();
	List<Llamada> lista2 = new ArrayList<Llamada>();
	GuiaTelefonica lista3 = new GuiaTelefonica();
	static double descuentoJur = 0.15;
	static double descuentoFis = 0;
	
	public boolean agregarTelefono(String str) {
		boolean encontre = lista3.guia.contains(str);
		if (!encontre) {
			lista3.guia.add(str);
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
			String tel = lista3.guia.last();
			lista3.guia.remove(tel);
			var.setTipo(t);
			var.setTelefono(tel);
			var.setDni(data);
		}
		else if (t.equals("juridica")) {
			String tel = lista3.guia.last();
			lista3.guia.remove(tel);
			var.setNombreYApellido(nombre);
			var.setTipo(t);
			var.setTelefono(tel);
			var.setDni(data);
		}
		var.setSistema(this);;
		lista1.add(var);
		return var;
	}
	
	public boolean eliminarUsuario(Cliente p) {
		List<Cliente> l = p.getSistema().lista1.stream().filter(persona -> persona != p).collect(Collectors.toList());
		boolean borre = false;
		if (l.size() < lista1.size()) {
			this.lista1 = l;
			this.lista3.guia.add(p.getTelefono());
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
		lista2.add(x);
		q.getLlamadasRealizadas().add(x);
		return x;
		
	}
	
	public double calcularMontoTotalLlamadas(Cliente p) {
		double c = 0;
		Cliente aux = null;
		for (Cliente pp : lista1) {
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
					auxc -= auxc*descuentoFis;
				} else if(aux.getTipo() == "juridica") {
					auxc -= auxc*descuentoJur;
				}
				c += auxc;
			}
		}
		return c;
	}

	public int cantidadDeUsuarios() {
		return lista1.size();
	}

	public boolean existeUsuario(Cliente persona) {
		return lista1.contains(persona);
	}
	
}
