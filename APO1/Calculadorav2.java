import java.util.Scanner;

public class Calculadorav2 {
	
	public static void main (String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Por favor escribe el número 1: ");
		int entero1 = entrada.nextInt();
		System.out.println("Por favor escribe el número 2: ");
		int entero2= entrada.nextInt();
		//
		int resSuma;
		resSuma = sumaDosNumeros(entero1,entero2);
		System.out.println("La suma es: " + resSuma);
	}
	/**
	*Descripcion: método que toma dos números y la suma.
	*@param int numero1 debe ser entero y mayores que 0.
	*@param int numero2 debe ser entero y mayores que 0.
	*/
	public static int sumaDosNumeros (int numero1, int numero2){
		int resultado;
		resultado= numero1 + numero2;
		return resultado;
	}
}