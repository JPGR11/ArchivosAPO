import java.util.Scanner;

public class QueenPapa {
	
	public static void main (String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Ingresa la cantidad de productos que desea: ");
		int cantidad_producto = entrada.nextInt();
	
		//Operaciones
		
		int precio_salchipapa = 65000 * cantidad_producto;
		double precio_impuestos = precio_salchipapa * 0.08;
		double precio_total = precio_impuestos + precio_salchipapa;
		
		//Mostrar
		System.out.println("---------------------------------");
		System.out.println("Queen Papa");
		System.out.println("Factura");
		System.out.println(cantidad_producto + "x Queen Salchi..... $ " + precio_salchipapa);
		System.out.println("Impuestos del consumo (8%)..... $ " + precio_impuestos);
		System.out.println("---------------------------------");
		System.out.println("Total a pagar..... $ " + precio_total);
		System.out.println("¡Muchas gracias por comprar en Queen Papa!");
		System.out.println("---------------------------------");

	}
}