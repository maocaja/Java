package com.oop.triangulo;

public final class Lado {
	
	private double longitud;
	
	public Lado( double longitud) {
		
		if(longitud < 0){
			throw new ArithmeticException("EL lado de un triangulo no puede ser menor que cero");
		}
		this.longitud = longitud;
	}

	public double getLongitud() {
		return longitud;
	}
	
	

}
