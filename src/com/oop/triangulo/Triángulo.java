package com.oop.triangulo;

public class Triángulo {
	
	private Lado ladoA;
	private Lado ladoB;
	private Lado ladoC;
	private Angulo anguloA;
	private Angulo anguloB;
	private Angulo anguloC;
	
	public Triángulo(Lado ladoA, Lado ladoB, Lado ladoC) {
		
		this.ladoA = ladoA;
		this.ladoB = ladoB;
		this.ladoC = ladoC;
		
	}
	
    public Triángulo(Lado ladoA, Lado ladoB, Angulo anguloA) {
		
		this.ladoA = ladoA;
		this.ladoB = ladoB;
		this.anguloA = anguloA;
		
	}
    
    public Triángulo(Lado ladoA, Angulo anguloA, Angulo anguloB) {
    	
		this.ladoA = ladoA;
		this.anguloA = anguloA;
		this.anguloB = anguloB;
		
	}
    
    public Triángulo(Lado ladoA, Lado ladoB,Angulo anguloA, Angulo anguloB) {
    	
		this.ladoA = ladoA;
		this.anguloA = anguloA;
		this.ladoB = ladoB;
		this.anguloB = anguloB;
		
	}
    
    public Triángulo(Lado ladoA, Lado ladoB,Angulo anguloA, Angulo anguloB, Angulo anguloC) {
    	
		this.ladoA = ladoA;
		this.anguloA = anguloA;
		this.ladoB = ladoB;
		this.anguloB = anguloB;
		this.anguloC = anguloC;
		
	}
    
    public Triángulo(Lado ladoA, Lado ladoB, Lado ladoC, Angulo anguloA) {
		
		this.ladoA = ladoA;
		this.ladoB = ladoB;
		this.ladoC = ladoC;
		this.anguloA = anguloA;
		
	}
    
	public Lado getLadoA() {
		return ladoA;
	}

	public Lado getLadoB() {
		return ladoB;
	}

	public Lado getLadoC() {
		return ladoC;
	}

	public Angulo getAnguloA() {
		return anguloA;
	}

	public Angulo getAnguloB() {
		return anguloB;
	}

	public Angulo getAnguloC() {
		return anguloC;
	}	
}
