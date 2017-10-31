package com.oop.builder.tríangulo;

public final class LeySeno {
	
	// calcular el angula x en radianes dado los lados a,b y angulo A
	public static double getAngleX(double sideX, double side, double angle) {
		return  Math.asin((sideX * Math.sin(angle)/side));
	}
	
	// calcular el angula x en radianes dado los lados a,b y angulo A
	public static double getSideX(double angleX, double side, double angle) {
		return  ((angleX * side * Math.sin(angleX))/Math.sin(angle));
	}
	
}
