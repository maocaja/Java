package com.oop.juegoconway;

public final class Tablero {
	
	private final int filas;
	private final int columnas;
	private final Celula tablero [][];
	
	
	public Tablero(int filas,int columnas,String celulas) {
		this.filas = filas;
		this.columnas = columnas;
		tablero = new Celula [this.filas][this.columnas];
		validarCelulas(celulas);
		llenarTablero(celulas);
	}
	private void validarNúmeroCelulas(String celulas){
		int númeroCelulas = (this.filas * this.columnas);
		if (númeroCelulas != celulas.length()){
			throw new ArithmeticException("Validar, el mundo inicial debe tener " + this.filas * this.columnas + " células"); 
		}
	}
	
	private void validarContenidoCélulas(String células){
		String celula = "";
		for (int i = 0; i < células.length(); i++) {
			celula = células.charAt(i)+"";
			if (!(celula.equals("0")  || celula.equals("1"))){
				throw new ArithmeticException("Validar mundo inicial debe tener valores 0 o 1, no " + celula); 
			}
		}
	}
	private void validarCelulas(String células) {
		validarNúmeroCelulas(células);
		validarContenidoCélulas(células);
		
	}
	
	private void llenarTablero (String celulas){
		int posición = 0;
		String celula;
		System.out.println(celulas);
		for (int i = 0; i < this.filas; i++) {
			for (int j = 0; j < this.columnas; j++) {
				celula = celulas.charAt(posición)+"";
				if (celula.equals("1")){
					tablero[i][j] = Celula.VIVA;
				}else if (celula.equals("0")){
					tablero[i][j] = Celula.MUERTA;
				}
				posición ++;
			}
		}
	}

	public int getFilas() {
		return filas;
	}

	public int getColumnas() {
		return columnas;
	}

	public Celula[][] getTablero() {
		return tablero;
	}
}
