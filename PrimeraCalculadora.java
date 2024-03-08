public class PrimeraCalculadora {
	public static void main(String[] args) {
		int NUMERO1 = 8;
		int NUMERO2= 3;
		
		//Calculos
		
		int suma = NUMERO1 + NUMERO2; // Calcular suma
		int resta = NUMERO1 - NUMERO2; // Calcular resta
		int multiplicacion = NUMERO1 * NUMERO2; //Calcular multiplicación
		int division = NUMERO1 / NUMERO2; //Calcular división
		int mod = NUMERO1 % NUMERO2; //Calcular módulo
		
		//Mostrar resultados
		
		System.out.println("La suma entre 8 y 3 es: " + suma); //Mostrar suma
		System.out.println("La resta entre 8 y 3 es: " + resta); //Mostrar resta
		System.out.println("La multiplicación entre 8 y 3 es: " + multiplicacion); //Mostrar multiplicación
		System.out.println("La división entre 8 y 3 es: " + division); //Mostrar división
		System.out.println("El módulo entre 8 y 3 es: " + mod); //Mostrar mod
	}
}