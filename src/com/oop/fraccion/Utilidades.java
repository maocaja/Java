package com.oop.fraccion;

public final class Utilidades {
	
	private Utilidades() {
		throw new UnsupportedOperationException("Not instanciable class!");
	}
	
	public static final int devuelveMcd(int numerador, int denominador) {
		return denominador == 0 ? numerador : devuelveMcd(denominador, numerador % denominador);
	}
	
	public static final int devuelveMcm(int denominadorUno, int denominadorDos) {
		   return denominadorUno * denominadorDos / devuelveMcd(denominadorUno, denominadorDos);
	}

}

