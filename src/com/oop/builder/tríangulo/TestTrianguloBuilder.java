package com.oop.builder.tríangulo;


public class TestTrianguloBuilder {
	
	public static void main(String[] args) throws Exception {
		
		Angulo angulo = new Angulo(Unidad.GRADOS,100);
		Lado ladoA = new Lado(10);
		Lado ladoB = new Lado(9);
		Lado ladoC = new Lado(15);
		
		Tríangulo triangulo = new Tríangulo.Builder().ladoA(ladoA).ladoB(ladoB).ladoC(ladoC).build();
		
		System.out.println(triangulo.toString());
	}

}
