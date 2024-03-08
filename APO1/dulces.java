import java.util.Scanner;

public class dulces {
	
	public static void main (String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Ingresa la cantidad de dulces que desea: ");
		int cantidad_producto = entrada.nextInt();
	
		//Operaciones
		
		int precio_dulce = 300 * cantidad_producto;
		double precio_impuestos = precio_dulce * 0.16;
		double precio_total = precio_impuestos + precio_dulce;
		
		//Mostrar
		System.out.println("---------------------------------");
		System.out.println("Dulces Caro");
		System.out.println("Factura");
		System.out.println(cantidad_producto + "x dulces..... $ " + precio_dulce);
		System.out.println("Impuestos del consumo (16%)..... $ " + (int) precio_impuestos);
		System.out.println("---------------------------------");
		System.out.println("Total a pagar..... $ " + (int) precio_total);
		System.out.println("Â¡Muchas gracias por comprar en Dulces Caro!");
		System.out.println("---------------------------------");

	}
}