package com.pe.jazb.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JavaOptionalExample {

	public static void main(String... strings) {

		JavaOptionalExample servicios = new JavaOptionalExample();

		String data = servicios.buscar("Gema");
		System.out.println(data);
		
		Optional<String> buscarPersonas = servicios.buscarPersona("Vicky");
		
		if (buscarPersonas.isPresent()) {
			System.out.println(buscarPersonas);
		}else{
			System.out.println("no hay registros");
		}
 	}

	public List<String> listaPersonas() {

		List<String> personas = new ArrayList<>();

		personas.add("Juan");
		personas.add("Jose");
		personas.add("Carlos");
		
		return personas;
	}
	
	//forma convencional
	public String buscar(String persona){
		
		List<String> lista = listaPersonas();
		String data = "";
		for (String nombre: lista) {
			if (persona.equals(nombre)) {
				return nombre;
			}
		}
		
		return null; 
	}
	
	//java8 Optional
	public Optional<String> buscarPersona(String persona){
		
		List<String> data = listaPersonas();

		for (String nombre : data) {
			if (nombre.equals(persona)) {
				return Optional.of(nombre);
			}
		}
		return Optional.empty(); 
		
	}
	

}
