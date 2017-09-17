package com.oop.fraccion;

public class Fracción {
	
	private int numerador;
	private int denominador;
	
	public Fracción(int numerador, int denominador ) {
		if (denominador == 0){
			throw new ArithmeticException("El denominador no puede ser cero"); 
		}
		int mcd = Utilidades.devuelveMcd(numerador,denominador);
		this.numerador   = numerador/mcd;
		this.denominador = denominador/mcd;
	}
	
	private Fracción transformarMismoDenominador(int numeador,int denominador, int mcm){
		Fracción NuevaFracción = new Fracción(((mcm /denominador) * numerador),mcm);
		return NuevaFracción;
	}
	private Fracción operar(Fracción otra, String signo){
		int mcm = Utilidades.devuelveMcm(this.denominador, otra.denominador);		
		Fracción fraccionUnoNueva =  transformarMismoDenominador(this.numerador, this.denominador,mcm);
		Fracción fraccionDosNueva =  transformarMismoDenominador(otra.getNumerador(),otra.getDenominador(), mcm);
		Fracción fracciónResultado;
		if (signo.equals("+")){
			 fracciónResultado = new Fracción((fraccionUnoNueva.numerador + fraccionDosNueva.numerador), mcm);
		}else {
			 fracciónResultado = new Fracción((fraccionUnoNueva.numerador - fraccionDosNueva.numerador), mcm);
		}
		return fracciónResultado;
	}
	
	public Fracción sumar (Fracción otra){
		
		return operar(otra, "+");
	}
	
	public Fracción Restar (Fracción otra){
		return operar(otra, "-");
	}
	
	public String toString(){
		String fracción = ""; 
		if (this.denominador == 1){
			fracción = String.valueOf(this.numerador);
		}else{
			fracción = this.numerador + "/" + this.denominador;
		}
		return fracción;
	}
	
	public int getNumerador() {
		return numerador;
	}

	public int getDenominador() {
		return denominador;
	}	
}
