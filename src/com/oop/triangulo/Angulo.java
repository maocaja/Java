package com.oop.triangulo;

public final class Angulo {
	private final Unidad unidad;
	private final double angulo;	

	public Angulo(Unidad unidad, int angulo) {
		switch (unidad) {
			case GRADOS:
				this.angulo = Utilidades.calcularAnguloEnGrados(angulo);
				break;
			case RADIAN:        	
				this.angulo = 0; // esta pendiente de hacer
				break;
			default:
        	 this.angulo = 0;
		}
		this.unidad = unidad;	
	}
	
	public String toString(){
		return "Unidades:" + this.unidad + " angulo:" + this.angulo; 
	}
	
	public Unidad getUnidad() {
		return unidad;
	}

	public double getAngulo() {
		return angulo;
	}


}
