package com.oop.juegoconway;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class Plano {
	
	private String nombre ;
	private String autor;
	private int generaciones;
	private int filas;
	private int columnas;
	private String mundoInicial;
	
	public Plano() {
		try {
			Properties propiedades = new Properties();
			URL url = ClassLoader.getSystemResource("properties/archivo.propierties");
			propiedades.load(url.openStream());
			nombre = propiedades.getProperty("nombreJuego");
			autor = propiedades.getProperty("autor");
			generaciones = Integer.parseInt(propiedades.getProperty("generaciones"));
			filas = Integer.parseInt(propiedades.getProperty("filas"));
			columnas = Integer.parseInt(propiedades.getProperty("columnas"));
			mundoInicial = propiedades.getProperty("mundoInicial");
		} catch (FileNotFoundException e) {
			System.out.println("Error, El archivo no exite");
		} catch (IOException e) {
			System.out.println("Error, No se puede leer el archivo");
		}
	}

	public String getNombre() {
		return nombre;
	}

	public String getAutor() {
		return autor;
	}

	public int getGeneraciones() {
		return generaciones;
	}

	public int getFilas() {
		return filas;
	}

	public int getColumnas() {
		return columnas;
	}

	public String getMundoInicial() {
		return mundoInicial;
	}
 
}