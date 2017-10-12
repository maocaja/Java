package com.oop.triangulo;

public final class Triángulo {
	
	private final Angulo anguloA;
	private final Angulo anguloB;
	private final Angulo anguloC;
	private final Lado ladoA;
	private final Lado ladoB;
	private final Lado ladoC;
	
	private Triángulo(Builder builder) {
		this.anguloA = builder.anguloA;
		this.anguloB = builder.anguloB;
		this.anguloC = builder.anguloC;
		this.ladoA   = builder.ladoA;
		this.ladoB   = builder.ladoB;
		this.ladoC   = builder.ladoC;
	}
	
	public Angulo getAnguloA() {
		return anguloA;
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
	public Angulo getAnguloB() {
		return anguloB;
	}

	public Angulo getAnguloC() {
		return anguloC;
	}
	 
	public static class Builder{
		
		private final Angulo anguloA; // mandatory
		private Angulo anguloB; 
		private Angulo anguloC; 
		private final Lado ladoA;
		private Lado ladoB;
		private Lado ladoC;
		
		public Builder(Angulo anguloA, Lado ladoA) { // constructor of static class Builder
			this.anguloA = anguloA;
			this.ladoA = ladoA;
		}
		
		public Builder anguloB(Angulo anguloA) {
			this.anguloB = anguloA;
		    return this;
		}
		
		public Builder anguloC(Angulo anguloC) {
			this.anguloB = anguloA;
		    return this;
		}
		
		
		public Builder ladoB(Lado lado) {
			this.ladoB = lado;
		    return this;
		}
		
		public Builder ladoC(Lado lado) {
			this.ladoC = lado;
		    return this;
		}
		
		public Triángulo build() {
		    return new Triángulo(this);
		}
		
	}
}
