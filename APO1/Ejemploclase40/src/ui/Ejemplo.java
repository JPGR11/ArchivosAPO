package ui;

import java.util.Scanner;

public class Ejemplo {
	
	public static void main (String[] args) {
		
		//Constante
		final double PI = 3.14159265359;
		System.out.println("La constante Pi es: " + PI);
		//Casting
		int piSinDecimales = (int) PI;
		System.out.println("La constante de Pi sin decimales es: " + piSinDecimales);
		piSinDecimales = piSinDecimales + 10;
		System.out.println(piSinDecimales);
		piSinDecimales += 10;
		System.out.println(piSinDecimales);
	}
}