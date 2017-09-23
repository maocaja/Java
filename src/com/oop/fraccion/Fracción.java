package com.oop.fraccion;

public final class Fracción {
	
	private final int numerador;
	private final int denominador;
	
	public Fracción(int numerador, int denominador ) {
		if (denominador == 0){
			throw new ArithmeticException("El denominador no puede ser cero"); 
		}
		int mcd = Utilidades.devuelveMcd(numerador,denominador);
		this.numerador   = numerador/mcd;
		this.denominador = denominador/mcd;
	}
	
	private Fracción operar(Fracción otra){
		int mcm = Utilidades.devuelveMcm(this.denominador, otra.denominador);	
		int numeradorUno = (mcm /this.denominador) * this.numerador;
		int numeradorDos = (mcm /otra.getDenominador()) * otra.getNumerador();
		Fracción fraccionUnoNueva =  new Fracción(numeradorUno,mcm);
		Fracción fraccionDosNueva =  new Fracción(numeradorDos,mcm);
		Fracción fracciónResultado;
		fracciónResultado = new Fracción((fraccionUnoNueva.numerador + fraccionDosNueva.numerador), mcm);
		return fracciónResultado;
	}
	
	public Fracción opuesta (Fracción otra){
		return new Fracción(otra.numerador * - 1 , denominador);
	}
	
	public Fracción sumar (Fracción otra){
		return operar(otra);
	}
	
	public Fracción restar (Fracción otra){
		return operar(otra.opuesta(otra));
	}
	
	public String toString() {
		return this.denominador == 1 ? String.valueOf(this.numerador) : this.numerador + "/" + this.denominador;
	}
		
	public int getNumerador() {
		return numerador;
	}

	public int getDenominador() {
		return denominador;
	}	
}
