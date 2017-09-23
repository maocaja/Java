package com.oop.triangulo;

public class TestTriangulo {
	public static void main(String[] args) {
		// estoy probando valores
		double anguloB = Utilidades.calcularLeyCosenoAnguloB(7.5, 11, 5);
		System.out.println(anguloB);
		double anguloA = Utilidades.calcularLeySenoAngulo(7.5, 11, anguloB);
		System.out.println(anguloA);
		
		double anguloC = 180 - (anguloA + anguloB);
		System.out.println(anguloC);
	}

}
