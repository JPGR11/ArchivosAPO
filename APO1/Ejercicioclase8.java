import java.util.Scanner;

public class Ejercicioclase8 {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main (String[] args) {
		pedir_info("cédula");
		int cedulausuario;
		cedulausuario = lee_dato();
		pedir_info("día");
		int dia;
		dia = lee_dato();
		System.out.println(calculoModulo(cedulausuario));
		System.out.println(calculoModulo(dia));
		if(decisionFinal() = true){
			System.out.println("Puedes salir.");
		}else if(decisionFinal() = false){
			System.out.println("No puedes salir.");
		}
	}
	
	/**
	*Descripcion: método que pida la cédula
	*/
	
	public static void pedir_info(String dato){
		System.out.println("Introduce la " + dato);
		
	}
	
	/**
	*Descripcion: método que lee con ayuda del escaner la información.
	*@param int cedula, tiene que ser entero
	*/
	
	public static int lee_dato(){
		int info = sc.nextInt();
		return info;
		
	}
	
	/**
	*Descripcion: método que hace el modulo de los datos
	*@param int mod, modulo de los datos.
	*@return int mod del número.
	*/
	
	public static int calculoModulo(int entero){
		int res = entero % 2;
		return res;
	}
	
	/**
	*Descripcion: toma los resultados de los modulos y segun si son iguales determina si sale o no.
	*@param int cedula
	*@param int dia
	*@return Decision si puede salir o no.
	*/
	
	public static boolean condicional(int cedula, int dia){
		boolean decisionFinal;
		if(calculoModulo(cedula) == calculoModulo(dia)){
			decisionFinal = true;
		}else{
			decisionFinal = false;
		}
		return decisionFinal;
	}
	
	public static String mensaje1(String mensaje) {
		if calculoModuloModulo(>)
	}
}