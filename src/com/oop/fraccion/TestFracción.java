package com.oop.fraccion;

public class TestFracción {
	
	public static void main(String[] args) throws Exception {
		
		Fracción fracción = new Fracción(8,4);
		
		fracción.imprimirFracción();
		
		Fracción fracciónSimplificada = fracción.simplificarFracción(fracción);
		fracciónSimplificada.imprimirFracción();
		
		Fracción ResultadoSumaFracción = fracción.sumarFracción(fracción, fracción);
		ResultadoSumaFracción.imprimirFracción();
		
		Fracción ResultadoRestaFracción = fracción.RestarFracción(fracción, fracción);
		ResultadoRestaFracción.imprimirFracción();
		
	}

}


