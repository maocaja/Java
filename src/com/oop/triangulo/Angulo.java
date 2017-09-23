package com.oop.triangulo;

public class Angulo {
	private String nombre;
	private double grados;
	
	public Angulo(String nombre, double grados){
		
		if(grados < 0 || grados > 180   ||nombre.isEmpty() ){
			throw new ArithmeticException("EL angulo de un triangulo no puede ser menor que cero");
		}
		this.nombre = nombre;
		this.grados = grados;
	}

	public String getNombre() {
		return nombre;
	}

	public double getGrados() {
		return grados;
	}
	
	

}
