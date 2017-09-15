package com.oop.fraccion;


public class Fracción {
	
	private int numerador;
	private int denominador;
	
	public Fracción(int numerador, int denominador ) {
		if (denominador == 0){
			throw new ArithmeticException("El denominador no puede ser cero"); 
		}
		this.numerador = numerador;
		this.denominador = denominador;
	}
	
	public int devuelveMcd(int numerador, int denominador) {
		return denominador == 0 ? numerador : devuelveMcd(denominador, numerador % denominador);
	}
	
	public int devuelveMcm(int numerador, int denominador) {
		   return numerador * denominador / devuelveMcd(numerador, denominador);
	}
	
	public Fracción simplificarFracción(Fracción fracción){		
		int mcd = devuelveMcd(fracción.numerador,fracción.denominador);
		Fracción FracciónSimplificada = new Fracción(fracción.numerador / mcd, fracción.denominador/mcd);		
		return FracciónSimplificada;
	}
	
	public void imprimirFracción() {
		if (this.numerador == 0){
			System.out.println("0");			
		}else{
			System.out.println(this.numerador + "/" + this.denominador);
		}
	}	
	
	private Fracción devolverNuevaFraccion(Fracción fracción, int mcm){
		Fracción NuevaFracción = new Fracción(((mcm /fracción.denominador) * fracción.numerador),mcm);
		return NuevaFracción;
	}
	
	public Fracción sumarFracción (Fracción fracciónUno, Fracción fracciónDos){
		int mcm = devuelveMcm(fracciónUno.denominador, fracciónDos.denominador);		
		Fracción fraccionUnoNueva =  devolverNuevaFraccion(fracciónUno,mcm);
		Fracción fraccionDosNueva =  devolverNuevaFraccion(fracciónDos,mcm);
		Fracción fracciónResultado = new Fracción((fraccionUnoNueva.numerador + fraccionDosNueva.numerador), mcm);
		return fracciónResultado;
	}
	
	public Fracción RestarFracción (Fracción fracciónUno, Fracción fracciónDos){
		int mcm = devuelveMcm(fracciónUno.denominador, fracciónDos.denominador);		
		Fracción fraccionUnoNueva =  devolverNuevaFraccion(fracciónUno,mcm);
		Fracción fraccionDosNueva =  devolverNuevaFraccion(fracciónDos,mcm);
		Fracción fracciónResultado = new Fracción((fraccionUnoNueva.numerador - fraccionDosNueva.numerador), mcm);
		return fracciónResultado;
	}
	
	public int getNumerador() {
		return numerador;
	}

	public int getDenominador() {
		return denominador;
	}	
}
