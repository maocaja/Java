package com.oop.builder.tríangulo;

public final class Angulo {
	
	private final Unidad unidad;
	private final double angulo;
	
	public Angulo(Unidad unidad, double angulo) throws Exception {
		this.unidad = unidad;
		switch (unidad) {
			case GRADOS:
				this.angulo = calcularAnguloEquivalenteGrados(angulo);
				break;
			case RADIAN:  
				if (validarAnguloRadianes(angulo)){
					this.angulo = angulo;
				}else{
					throw new Exception("El ángulo en Radianes debe estar entre 0 y PI ");
				}
				break;
			default:
				throw new AssertionError("Tipo de unidad desconocida  " + this);
		}
	}
	
	
	private double calcularAnguloEquivalenteGrados(double angulo){
		if (angulo != 0){
			return angulo % 360;
		}else{
			throw new AssertionError("El angulo debe ser diferente de cero " + this);
		}
	}
	
	private boolean validarAnguloRadianes(double angulo){
		if (angulo > 0 && angulo < 2 * Math.PI) {
			return true;
		}else{
			return false;
		}
	}
	
	public Unidad getUnidad() {
		return unidad;
	}

	public double getAngulo() {
		return angulo;
	}
	
	public String toString(){
		return "La longitud del angulo es de: " + this.angulo + " "+ this.unidad ;
	}

}
