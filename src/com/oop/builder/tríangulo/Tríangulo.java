package com.oop.builder.tríangulo;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.co.tríangulo.LeyCoseno;
import com.co.tríangulo.LeySeno;

public class Tríangulo {
	
	private final Angulo anguloA;
	private final Angulo anguloB;
	private final Angulo anguloC;
	private final Lado ladoA;
	private final Lado ladoB;
	private final Lado ladoC;

	
	private Tríangulo(Builder builder) {
		this.anguloA = builder.anguloA;
		this.anguloB = builder.anguloB;
		this.anguloC = builder.anguloC;
		this.ladoA   = builder.ladoA;
		this.ladoB   = builder.ladoB;
		this.ladoC   = builder.ladoC;
	}
	
	public static class Builder{
		
		private Angulo anguloA;
		private Angulo anguloB;
		private Angulo anguloC;
		private Lado ladoA;
		private Lado ladoB;
		private Lado ladoC;
		
		
		private  Map<String, Lado> mapaLados = new HashMap<String, Lado>();
		private Map<String, Angulo> mapaAngulos = new HashMap<String, Angulo>();

		
		public Builder anguloA(Angulo angulo) throws Exception {
			if (!mapaAngulos.containsKey("a")){
				this.anguloA = angulo;
				mapaAngulos.put("a", angulo);
			    return this;
			}else{
				throw new UnsupportedOperationException("El angulo A ya fue asignado");
			}
			
		}
		
		public Builder anguloB(Angulo angulo) throws Exception {
			if (!mapaAngulos.containsKey("b")){
				this.anguloB = angulo;
				mapaAngulos.put("b", angulo);
				return this;
			}else{
				throw new UnsupportedOperationException("El angulo B ya fue asignado");
			}
		}
		
		public Builder anguloC(Angulo angulo) throws Exception {
			if (!mapaAngulos.containsKey("b")){
				this.anguloC = angulo;
				mapaAngulos.put("c", angulo);
				return this;
			}else{
				throw new UnsupportedOperationException("El angulo C ya fue asignado");
			}
		}
		
		public Builder ladoA(Lado lado) {
			if (!mapaLados.containsKey("a")){
				this.ladoA = lado;
				mapaLados.put("a", lado);
				return this;
			}else{
				throw new UnsupportedOperationException("El lado a ya fue asignado");
			}
		}
		
		public Builder ladoB(Lado lado) {
			if (!mapaLados.containsKey("b")){
				this.ladoB = lado;
				mapaLados.put("b", lado);
				return this;
			}else{
				throw new UnsupportedOperationException("El lado b ya fue asignado");
			}
		}
		
		public Builder ladoC(Lado lado) {
			if (!mapaLados.containsKey("c")){
				this.ladoC = lado;
				mapaLados.put("c", lado);
				return this;
			}else{
				throw new UnsupportedOperationException("El lado c ya fue asignado");
			}
		}
		
		private void evaluarLadosRepetidos(){
			double tmp = 0;
			int contador = 0;
			
			for (Entry<String, Lado> lado: mapaLados.entrySet()) {
		        if (lado.getValue().getLongitud() == tmp){
					contador ++;
				}else{
					tmp = lado.getValue().getLongitud();
				}
		    }
			
			if (contador >= mapaLados.size()-1) {
				throw new UnsupportedOperationException("Los tres lados no pueden ser iguales");
			}
		}
		
		private void validarTríangulo() {
			if (mapaLados.isEmpty()) {
				throw new UnsupportedOperationException("Debe ingresar al menos un lado");
			}
			if (mapaLados.size() <= 1 && mapaAngulos.size() <= 1) {
				throw new UnsupportedOperationException("Debe ingresar al menos dos angulos y un lado o dos lados y un angulo");
			}
			if (mapaLados.size() == 0 && mapaAngulos.size() < 3) {
				throw new UnsupportedOperationException("Si no ingresa angulos debe ingresar los tres lados");
			}
			if(mapaLados.size() > 2 ){
				evaluarLadosRepetidos();
			}
        }
		
		private final boolean isTríanguloResuelto (){
			if (mapaLados.size() == 3 && mapaAngulos.size() == 3){	
				return false;
			}else{
				return true;
			}
		}
		
		private static final float calcularAngulo(double angleOne, double angleTwo){
			return (float) (180 - (Math.toDegrees(angleOne) + Math.toDegrees(angleTwo)));
		}
		
		private final void calcularÚltimoÁngulo() throws Exception{
			
			double angulo;
			
			if (!mapaAngulos.containsKey("a")){
				angulo = calcularAngulo(mapaAngulos.get("b").getAngulo(), 
										mapaAngulos.get("c").getAngulo());
				mapaAngulos.put("a", new Angulo(Unidad.GRADOS, angulo));
			}
			
			if (!mapaAngulos.containsKey("b")){
				angulo = calcularAngulo(mapaAngulos.get("a").getAngulo(), 
									    mapaAngulos.get("c").getAngulo());
				mapaAngulos.put("b", new Angulo(Unidad.GRADOS, angulo));
			}
			
			if (!mapaAngulos.containsKey("c")){
				angulo = calcularAngulo(mapaAngulos.get("a").getAngulo(), 
									    mapaAngulos.get("b").getAngulo());
				mapaAngulos.put("c", new Angulo(Unidad.GRADOS, angulo));
			}
			
		}
		
		private final void calcularLadoA(){
			double lado;

			if (mapaLados.containsKey("b") && mapaAngulos.containsKey("b") ) {
				lado = LeySeno.getSideX(mapaAngulos.get("a").getAngulo(), 
										mapaLados.get("b").getLongitud(),
										mapaAngulos.get("b").getAngulo());
				ladoA = new Lado(lado);
				mapaLados.put("a", new Lado(lado));
				return;
		    }
		    
		    if (mapaLados.containsKey("c") && mapaAngulos.containsKey("c")) {
		    	lado = LeySeno.getSideX(mapaAngulos.get("a").getAngulo(),  
		    							mapaLados.get("c").getLongitud(),
		    							mapaAngulos.get("c").getAngulo());
		    	ladoA = new Lado(lado);
				mapaLados.put("a", new Lado(lado));
				return;
		    }
		}
		private final void calcularLadoB(){
			
			double lado;

			if ( mapaLados.containsKey("a") && mapaAngulos.containsKey("a") ) {
				lado = LeySeno.getSideX(mapaAngulos.get("b").getAngulo(), 
										mapaLados.get("a").getLongitud(),
										mapaAngulos.get("a").getAngulo());
				this.ladoB = new Lado(lado);
				mapaLados.put("b", new Lado(lado));
				return;
		    }
		    
		    if (mapaLados.containsKey("c") && mapaAngulos.containsKey("c")) {
		    	lado = LeySeno.getSideX(mapaAngulos.get("b").getAngulo(),  
		    						    mapaLados.get("c").getLongitud(),
		    						    mapaAngulos.get("c").getAngulo());
		    	this.ladoB = new Lado(lado);
				mapaLados.put("b", new Lado(lado));
				return;
		    }
			
		}
		private final void calcularLadoC(){
			
			double lado;

			if ( mapaLados.containsKey("a") && mapaAngulos.containsKey("a") ) {
				lado = LeySeno.getSideX(mapaAngulos.get("c").getAngulo(), 
										mapaLados.get("a").getLongitud(),
										mapaAngulos.get("a").getAngulo());
				this.ladoC = new Lado(lado);
				mapaLados.put("c", new Lado(lado));
				return;
		    }
		    
		    if (mapaLados.containsKey("b") && mapaAngulos.containsKey("b")) {
		    	lado = LeySeno.getSideX(mapaAngulos.get("c").getAngulo(),  
		    							mapaLados.get("b").getLongitud(),
		    							mapaAngulos.get("b").getAngulo());
		    	this.ladoC = new Lado(lado);
				mapaLados.put("c", new Lado(lado));
				return;
		    }
			
	    }
		
		private final void calcularLados(){
			
			if (!mapaLados.containsKey("a") && mapaAngulos.containsKey("a")){
				System.out.println("calcularLadoA");
				calcularLadoA();
				return;
		    }
			
			if (!mapaLados.containsKey("b") && mapaAngulos.containsKey("b")){
				System.out.println("calcularLadoB");
				calcularLadoB();
				return;
		    }
			
			if (!mapaLados.containsKey("c") && mapaAngulos.containsKey("c")){
				System.out.println("calcularLadoC");
				calcularLadoC();
				return;
		    }
		}
		
		private final void calcularAnguloA() throws Exception{
			double angulo;
		    // Calcular angulo A, dado el lado a, b  y angulo B 
		    if (mapaLados.containsKey("b") && mapaAngulos.containsKey("b")  ) {
		    	angulo = LeySeno.getAngleX(mapaLados.get("a").getLongitud(),
		    							   mapaLados.get("b").getLongitud(), 
		    							   mapaAngulos.get("b").getAngulo());
		    	
		    	this.anguloA = new Angulo(Unidad.GRADOS,Math.toDegrees(angulo));
				mapaAngulos.put("a", anguloA);
		    }
		   // Calcular angulo A, dado el lado a, c  y angulo C
		    if (mapaLados.containsKey("c") && mapaAngulos.containsKey("c")  ) {
		    	angulo = LeySeno.getAngleX(mapaLados.get("a").getLongitud(),
		    							   mapaLados.get("c").getLongitud(), 
		    							   mapaAngulos.get("c").getAngulo());
		    	
		    	this.anguloA = new Angulo(Unidad.GRADOS,Math.toDegrees(angulo));
				mapaAngulos.put("a", anguloA);
		    }
			
		}
		private final void calcularAnguloB() throws Exception{
			
			double angulo;

			// Calcular angulo B, dado el lado b, a  y angulo B 
		    if (mapaLados.containsKey("b") && mapaAngulos.containsKey("b")  ) {
		    	angulo = LeySeno.getAngleX(mapaLados.get("b").getLongitud(),
		    							   mapaLados.get("a").getLongitud(), 
		    							   mapaAngulos.get("a").getAngulo());
		    	this.anguloB = new Angulo(Unidad.GRADOS,Math.toDegrees(angulo));
				mapaAngulos.put("a", anguloB);
		    	return;
		    }

		    // Calcular angulo B, dado el lado b, a  y angulo B 
		    if (mapaLados.containsKey("a") && mapaAngulos.containsKey("c")  ) {
		    	angulo = LeySeno.getAngleX(mapaLados.get("b").getLongitud(),
		    							   mapaLados.get("c").getLongitud(), 
		    							   mapaAngulos.get("c").getAngulo());
		    	this.anguloB = new Angulo(Unidad.GRADOS,Math.toDegrees(angulo));
				mapaAngulos.put("b", anguloB);
		    	return;
		    }
			
		}
		private final void calcularAnguloC() throws Exception{
			
			double angulo;

			// Calcular angulo C, dado el lado c, a  y angulo C 
		    if (mapaLados.containsKey("a") && mapaAngulos.containsKey("c")  ) {
		    	angulo = LeySeno.getAngleX(mapaLados.get("c").getLongitud(),
		    							   mapaLados.get("a").getLongitud(), 
		    							   mapaAngulos.get("a").getAngulo());
		    	this.anguloC = new Angulo(Unidad.GRADOS,Math.toDegrees(angulo));
				mapaAngulos.put("a", anguloC);
		    	return;
		    }

		    // Calcular angulo C, dado el lado c, b  y angulo B
		    if (mapaLados.containsKey("a") && mapaAngulos.containsKey("c")  ) {
		    	angulo = LeySeno.getAngleX(mapaLados.get("c").getLongitud(),
		    							   mapaLados.get("b").getLongitud(), 
		    							   mapaAngulos.get("b").getAngulo());
		    	this.anguloC = new Angulo(Unidad.GRADOS,Math.toDegrees(angulo));
				mapaAngulos.put("a", anguloC);
		    	return;
		    }
		
		}
		
		private final void calcularTodosAngulos() throws Exception{
			double angulo;	
			angulo = LeyCoseno.getAngleA(mapaLados.get("a").getLongitud(), 
										 mapaLados.get("b").getLongitud(), 
										 mapaLados.get("c").getLongitud());
			this.anguloA = new Angulo(Unidad.GRADOS, Math.toDegrees(angulo));
			mapaAngulos.put("a", this.anguloA);
				
			angulo = LeyCoseno.getAngleB(mapaLados.get("a").getLongitud(), 
										 mapaLados.get("b").getLongitud(), 
										 mapaLados.get("c").getLongitud());
			this.anguloB = new Angulo(Unidad.GRADOS, Math.toDegrees(angulo));
			mapaAngulos.put("b", this.anguloB);
				
			angulo = LeyCoseno.getAngleC(mapaLados.get("a").getLongitud(), 
										 mapaLados.get("b").getLongitud(), 
										 mapaLados.get("c").getLongitud());
			this.anguloC = new Angulo(Unidad.GRADOS, Math.toDegrees(angulo));
			mapaAngulos.put("c", this.anguloC);
				
			return;
		}
		
		private final void calcularAngulos() throws Exception{
			
			if (!mapaAngulos.containsKey("a") && mapaLados.containsKey("a")){
				calcularAnguloA();
				return;
		    }
			
			if (!mapaAngulos.containsKey("b") && mapaLados.containsKey("b")){
				calcularAnguloB();
				return;
		    }
			
			if (!mapaAngulos.containsKey("c") && mapaLados.containsKey("c")){
				calcularAnguloC();
				return;
		    }
			
		}
		
		private void calcularCampos() throws Exception{
			if (mapaAngulos.size() == 2){
				calcularÚltimoÁngulo();
				return;
			}
			
			if (mapaAngulos.size() == 0 && mapaLados.size() == 3){	
				calcularTodosAngulos();
				return;
			}
			calcularLados();
			calcularAngulos();
		}
		
		private void resolverTríangulo() throws Exception{
			do{
				calcularCampos();
			}while (isTríanguloResuelto());
		}
		
		public Tríangulo build() throws Exception {
			validarTríangulo();
			resolverTríangulo();
		    return new Tríangulo(this);
		}
	}
	
	public final String toString(){
		return "La medidas del triangulo son: "+
				" lado a:"   + ladoA.getLongitud() + 
				" lado b: "  + ladoB.getLongitud() + 
				" lado c:  " + ladoC.getLongitud() + 
				" ángulo A:" + anguloA.getAngulo() + 
				" ángulo B:" + anguloB.getAngulo() + 
				" ángulo C"  + anguloC.getAngulo() ;    
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
}