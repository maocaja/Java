package com.oop.triangulo;

public class TestTriangulo {
	public static void main(String[] args) {
		
		
		Angulo anguloA = new Angulo(Unidad.GRADOS, -3650);
		System.out.println(anguloA.getAngulo());
		
		Lado ladoA = new Lado(25);
		
		Triángulo triangulo = new Triángulo.Builder(anguloA,ladoA).build();
		
		System.out.println(triangulo.getAnguloA().getUnidad());
		
	}

}
