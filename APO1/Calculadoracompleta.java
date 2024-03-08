import java.util.Scanner;

public class Calculadoracompleta {
	
	public static void main (String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Por favor escribe el número 1: ");
		int entero1 = entrada.nextInt();
		System.out.println("Por favor escribe el número 2: ");
		int entero2 = entrada.nextInt();
		
		//Operaciones
		
		int suma =  + entero2;
		int resta = entero1 - entero2; 
		int multiplicacion = entero1 * entero2; 
		int division = entero1 / entero2;
		int mod = entero1 % entero2;
		
		//Resultados
		
		System.out.println("El resultado de la suma es: " + suma);
		System.out.println("El resultado de la resta es: " + resta);
		System.out.println("El resultado de la multiplicación es: " + multiplicacion);
		System.out.println("El resultado de la división es: " + division);
		System.out.println("El resultado de la módulo es: " + mod);
	}
}