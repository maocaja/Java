package com.oop.juegoconway;

public final class Juego {
	
	private final Plano plano;
	private final Tablero tablero;
	
	public Juego(Plano plano) {
		this.plano = plano;
		this.tablero = new Tablero(plano.getFilas(), plano.getColumnas(), plano.getMundoInicial());
	}

	public Plano getPlano() {
		return plano;
	}
	
	private Celula [][] inicializarTableroFuturo(){
		return new Celula [plano.getFilas()][plano.getColumnas()];
	}
	
	public void jugar(){
		Celula tableroInicial [][] = tablero.getTablero();
		pintarIteracion(tableroInicial);
		for (int i = 1; i <= plano.getGeneraciones(); i++) {
			tableroInicial = recorrerTablero(tableroInicial);
			pintarIteracion(tableroInicial);
		}
	}
	
	public void pintarIteracion(Celula tableroActual[][]){
		
		for (Celula [] arreglo: tableroActual) {
			for (int i = 0; i < arreglo.length; i++) {
				if (arreglo[i] == Celula.VIVA){
					System.out.print("1 ");
				}else{
					System.out.print("0 ");
				}
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	public Celula [][] recorrerTablero(Celula tableroActual[][]){
		int numCelulasVivas = 0;
		Celula tableroFuturo [][] = inicializarTableroFuturo();
		for (int i = 0; i < tablero.getFilas(); i++) {
			for (int j = 0; j < tablero.getColumnas(); j++) {
				tableroFuturo[i][j] = tableroActual[i][j];
				numCelulasVivas = numeroCelulasVivas(i,j,tableroActual);
				if (tableroActual[i][j] == Celula.VIVA){ // viva
					if (numCelulasVivas ==  2 || numCelulasVivas == 3){
						tableroFuturo[i][j] = Celula.VIVA;
					}else{
						tableroFuturo[i][j] = Celula.MUERTA;
					}					
				}else{ 					 // muerta
					if (numCelulasVivas == 3){
						tableroFuturo[i][j] = Celula.VIVA;
					}					
				}  
			}
		}
		return tableroFuturo;
	}
	
	public int numeroCelulasVivas(int x, int y, Celula tableroActual[][]){
		int numCelulasVivas = 0;
		for (int i = x-1; i < x + 2; i++) {
			for (int j = y-1; j < y + 2; j++) {
				try {
					if (!(i == x && j == y)){
						if (tableroActual[i][j] == Celula.VIVA){
								numCelulasVivas ++;
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		return numCelulasVivas;
	}
	
	
}
