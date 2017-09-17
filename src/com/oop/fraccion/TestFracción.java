package com.oop.fraccion;

public class TestFracción {
	
	public static void main(String[] args) throws Exception {
		Fracción fracción = new Fracción(4, 2);
		System.out.println(fracción.toString());
		
		Fracción OtraFracción = new Fracción(4, 2);
		System.out.println(OtraFracción.toString());
		
		Fracción Sumafracción = fracción.sumar(OtraFracción);
		System.out.println(Sumafracción.toString());
	}

}


