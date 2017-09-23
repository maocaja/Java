package com.oop.triangulo;

public class Lado {
	
	private String nombre;
	private double longitud;
	
	public Lado(String nombre, double longitud) {
		
		if(longitud < 0  ||nombre.isEmpty() ){
			throw new ArithmeticException("EL lado de un triangulo no puede ser menor que cero");
		}
		this.nombre = nombre;
		this.longitud = longitud;
	}

	public String getNombre() {
		return nombre;
	}

	public double getLongitud() {
		return longitud;
	}
	
	

}
