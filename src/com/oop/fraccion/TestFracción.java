package com.oop.fraccion;

public class TestFracción {
	
	public static void main(String[] args) throws Exception {
		Fracción fracción = new Fracción(-4, 2);
		System.out.println(fracción.toString());
		
		Fracción otraFracción = new Fracción(4, 2);
		System.out.println(otraFracción.toString());
		
		Fracción sumafracción = fracción.sumar(otraFracción);
		System.out.println(sumafracción.toString());
		
		Fracción restafracción = fracción.restar(otraFracción);
		System.out.println(restafracción.toString());
	}

}


