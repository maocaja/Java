package com.oop.juegoconway;

public class TestJuegoConway {
	
	public static void main(String[] args) {
		Plano plano = new Plano();
		Juego juego = new Juego(plano);
		juego.jugar();
	}

}
