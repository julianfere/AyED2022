package Practica2;

import tp02.ejercicio2.*;
import practica1.*;

public class TestListaEnlazadaGenerica {
	public static void main(String[] args) {
		ListaEnlazadaGenerica<Alumno> lista = new ListaEnlazadaGenerica<>();

		for (int i = 1; i < 5; i++) {
			Alumno alumno = new Alumno();
			alumno.setLegajo(String.format("%s", 1));
			alumno.setNombre(String.format("Alumno %s", 1));
			alumno.setApellido(String.format("Apellido %s", 1));
			alumno.setEmail(String.format("alumno%s@gmail.com", 1));
			alumno.setDni(i);
			lista.agregarFinal(alumno);
		}
		
		lista.comenzar();
		while(!lista.fin()) {
			System.out.println(lista.proximo().tusDatos());
		}
	}
}
