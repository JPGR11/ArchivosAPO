import java.util.Scanner;

public class Ejercicioclase6 {
	
	public static void main (String[] args){
		Scanner in = new Scanner(System.in);
		
		String saborhelado; // Declararlo
		
		System.out.println("¿Cúal es tu sabor de helado favorito?");
		
		saborhelado = in.nextLine();
		
		System.out.println("Tu sabor elegido fue: " + saborhelado);
		
		double porcentajeComision;
		
		System.out.println("¿Cúal es el porcentaje de comision en la venta ? ");
		
		porcentajeComision = in.nextDouble();
		
		System.out.println("Tú porcentaje de comisión es: " + porcentajeComision);
	}
}