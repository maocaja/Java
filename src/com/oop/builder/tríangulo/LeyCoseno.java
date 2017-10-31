package com.oop.builder.tríangulo;

/*
 * Using the law of cosines, these functions return the angles of a triangle
 * based on the size of all three sides. Or the length of a side given its opposite angle
 * and the length of the other two sides.
 * Lower case variables are sides, upper case are the angle opposite the lower case side
 * i.e. "A" is the angle opposite side "a"
 *
 * The Law of Cosines:
 *  a = sqrt(Math.pow(b, 2) + Math.pow(c, 2) - 2 * b * c * Math.cos(A))
 *  b = sqrt(Math.pow(a, 2) + Math.pow(c, 2) - 2 * a * c * Math.cos(B)) 
 *  c = sqrt(Math.pow(a, 2) + Math.pow(b, 2) - 2 * a * b * Math.cos(C)) 
*/

public final class LeyCoseno {
	
	  // calcular el angula A en radianes dado los lados a,b y c
	  public static double getAngleA(double a, double b, double c) {
	    return  Math.acos((Math.pow(a, 2) - Math.pow(b, 2) - Math.pow(c, 2)) / (-2 * b * c));
	  }
	  
	  // Calcular el angulo B en radianes dados a,b y c
	  public static double getAngleB(double a, double b, double c) {
	    return  Math.acos((Math.pow(b, 2) - Math.pow(a, 2) - Math.pow(c, 2)) / (-2 * a * c));
	  }
	  
	  // Calcular el angulo C en radianes dados los lados a,b y c
	  public static double getAngleC(double a, double b, double c) {
	    return  Math.acos((Math.pow(c, 2) - Math.pow(a, 2) - Math.pow(b, 2)) / (-2 * b * a));
	  }


	  // calcular la longitud del lado a dado el angulo A y lados b y c
	  public static double getSideA(double A, double b, double c) {
	    return  Math.sqrt(Math.pow(b, 2) + Math.pow(c, 2) - 2 * b * c * Math.cos(A));
	  }
	  
	  // calcular la longitud del lado b, dado el angulo B y los lados a y c 
	  public static double getSideB(double B, double a, double c) {
	    return  Math.sqrt(Math.pow(a, 2) + Math.pow(c, 2) - 2 * a * c * Math.cos(B));
	  }
	  
	  // Calcular la longitud del lado c dado el angulo C y lados a y c
	  public static double getSideC(double C, double a, double b) {
	    return  Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2) - 2 * a * b * Math.cos(C));
	  }

	
}
