package com.oop.triangulo;

public final class Utilidades {
	
	private Utilidades() {
		throw new UnsupportedOperationException("Not instanciable class!");
	}
	
	public static final double calcularLeyCosenoAnguloA(double ladoA, double ladoB, double ladoC){
		return Math.toDegrees(Math.acos((Math.pow(ladoA, 2) - Math.pow(ladoB, 2) - Math.pow(ladoC, 2))/(-2 * ladoB * ladoC )));
	}
	
	public static final double calcularLeyCosenoAnguloB(double ladoA, double ladoB, double ladoC){
		return Math.toDegrees(Math.acos((Math.pow(ladoB, 2) - Math.pow(ladoA, 2) - Math.pow(ladoC, 2))/(-2 * ladoA * ladoC )));
	}
	
	public static final double calcularLeyCosenoAnguloC(double ladoA, double ladoB, double ladoC){
		return Math.toDegrees(Math.acos((Math.pow(ladoC, 2) - Math.pow(ladoA, 2) - Math.pow(ladoB, 2))/(-2 * ladoA * ladoB )));
	}
	
	public static final double calcularLeySenoAngulo(double ladoA, double ladoB, double anguloB){
		return Math.toDegrees(Math.asin((ladoA * Math.sin(Math.toRadians(anguloB))/ladoB))); 
	}
	
	public static final double calcularLeySenoLado(double anguloUno, double anguloDos, double lado){
		return (Math.sin(anguloUno) * (lado))/(Math.sin(anguloDos)); 
	}

}
