import java.util.Scanner;

public class seguimiento2{
	
	public static void main (String[] args) {
		
		//Llamado scanner
		
		Scanner sc = new Scanner(System.in);
		
		//Definición variables
		
		int dia_actual = 0;
		int mes_actual = 0;
		int año_actual = 0;
		
		//switches para hacer condicionales
		
		boolean sw_dia = false;
		boolean sw_mes = false;
		boolean sw_año = false;
		boolean sw_datos = false;
		
		
		//Verificación día, mes y año correctos
		
		while(sw_datos == false){
			
			//Introduce el dia y verifica que está dentro de los parámetros.
			
			while(sw_dia == false){
				System.out.println("Introduce el día de hoy (números): ");
				dia_actual  = sc.nextInt();
				if(dia_actual <= 31 && dia_actual > 0){
					sw_dia = true;
				} else {
					System.out.println("Día por fuera de los valores");
					sw_dia = false;
				}
			}
			
			//Reinicio de switch
			
			sw_dia = false;
			
			//Introduce el mes y verifica que está dentro de los parametros
			
			while(sw_mes == false){
				System.out.println("Introduce el mes actual (números): ");
				mes_actual = sc.nextInt();
				if(mes_actual <= 12 && mes_actual > 0){
					sw_mes = true;
				}else {
					System.out.println("Mes por fuera de los valores");
					sw_mes = false;
				}
			}
			
			//Reinicio de switch
			
			sw_mes = false;
			
			//Introduce el año y verifica que este dentro de los parametros.
			
			while(sw_año == false){
				System.out.println("Introduce el año actual(yyyy): ");
				año_actual = sc.nextInt();
				if(año_actual > 2000){
					sw_año = true;
				}else {
					System.out.println("Año por fuera de los valores");
					sw_año = false;
				}
			}
			
			//Reinicio de switch
			
			sw_año = false;
			
			//Comprueba si el año es bisiesto
			
			sw_datos = verificacion(mes_actual, dia_actual, año_actual);
		}
		
		//Fecha dia anterior
		
		int dia_anterior = dia_actual - 1;
		
		if(dia_anterior != 0){
			System.out.println("La fecha del día anterior es: " + dia_anterior + "/" + mes_actual + "/" + año_actual);
		}
		
		//En caso de que se cambie de mes
		
		if(dia_anterior == 0){
			String fecha_dia_anterior = cambio_mes(mes_actual,dia_anterior, año_actual);
			System.out.println("La fecha del día anterior es: " + fecha_dia_anterior);
		}
		
		//Fecha día actual
		
		String fecha_actual = dia_actual + "/" + mes_actual + "/" + año_actual;
		System.out.println("El día actual es: " + fecha_actual);
		
		//Fecha dia postior
		
		int dia_posterior = dia_actual + 1;
		
		if(mes_actual == 6 || mes_actual == 4 || mes_actual == 11 || mes_actual == 9 && dia_actual < 30){
			System.out.println("La fecha del día posterior es: " + dia_posterior + "/" + mes_actual + "/" + año_actual);
		} else if(año_especial(año_actual) == 0 && mes_actual==2){
			if(dia_actual < 29){
				System.out.println("La fecha del día posterior es: " + dia_posterior + "/" + mes_actual + "/" + año_actual);
			}else if(mes_actual==2 && dia_actual < 28 ){
				System.out.println("La fecha del día posterior es: " + dia_posterior + "/" + mes_actual + "/" + año_actual);
			}
		}else if(dia_actual < 31){
			System.out.println("La fecha del día posterior es: " + dia_posterior + "/" + mes_actual + "/" + año_actual);
		}
		
		//En caso de que se cambie de mes
		
		if(mes_actual == 6 || mes_actual == 4 || mes_actual == 11 || mes_actual == 9 && dia_posterior == 31){
			String fecha_dia_posterior = cambio_mes_posterior(mes_actual,dia_posterior, año_actual);
			System.out.println("La fecha del día posterior es: " + fecha_dia_posterior);
			
		} else if(año_especial(año_actual) == 0 && mes_actual==2){
			if(dia_posterior == 30){
				String fecha_dia_posterior = cambio_mes_posterior(mes_actual,dia_posterior, año_actual);
				System.out.println("La fecha del día posterior es: " + fecha_dia_posterior);
			}else if(mes_actual==2 && dia_posterior == 29 ){
				String fecha_dia_posterior = cambio_mes_posterior(mes_actual,dia_posterior, año_actual);
				System.out.println("La fecha del día posterior es: " + fecha_dia_posterior);
			}
		}else if(dia_posterior == 32){
			String fecha_dia_posterior = cambio_mes_posterior(mes_actual,dia_posterior, año_actual);
			System.out.println("La fecha del día posterior es: " + fecha_dia_posterior);
		}

	}
	/**
	*Descripcion: método que comprueba si un año es bisiesto.
	*@param int año debe ser entero y mayor que 2000.
	*@return int año_bisiesto, retorna el mod 4 del año, en donde si es 0 es bisiesto.
	*/
	public static int año_especial(int año){
		int año_bisiesto;
		año_bisiesto = año % 4;
		return año_bisiesto;
	}
	/**
	*Descripcion: método que verifica si la cantidad de días introducidos corresponde a la del mes.
	*@param int mes debe ser entero, mayores que 1 y menores que 12.
	*@param int dia debe ser entero, mayores que 1 y menore que 31.
	*@param int año debe ser entero y mayores que 2000.
	*@return boolean verificacion_fecha, retorna un valor booleano.
	*/
	public static boolean verificacion(int mes, int dia, int año){
		boolean verificacion_fecha;
		verificacion_fecha = false;
		switch(mes){
			
			case 6:
			case 9:
			case 4:
			case 11:
			if( dia >= 1 && dia <= 30){
				verificacion_fecha = true;
			}else{
				System.out.println("La fecha no es válida para el mes dado.");
				verificacion_fecha = false;
			}
			break;
			
			case 2:
			if(año_especial(año) == 0){
				if (mes == 2 && dia <= 29 && dia >= 1){
					verificacion_fecha = true;
				}else{
					System.out.println("El año es bisiesto, febrero tiene 29 días.");
				}
			}else if( dia >= 1 && dia <= 28){
					verificacion_fecha = true;
			}else{
				System.out.println("La fecha no es válida para el mes dado.");
				verificacion_fecha = false;
			}
			break;
			
			default:
			if(dia >= 1 && dia <= 31){
				verificacion_fecha = true;
			}else{
				System.out.println("La fecha no es válida para el mes dado.");
				verificacion_fecha = false;
			}
			break;
		}
		return verificacion_fecha;
	}
	/**
	*Descripcion: método que en cambia el mes y el dia; para generar el día anterior en caso que sea en el mes anterior al dado.
	*@param int mes debe ser entero, mayores que 1 y menores que 12.
	*@param int dia debe ser entero, mayores que 1 y menore que 31.
	*@param int año debe ser entero y mayores que 2000.
	*@return string dia + "/" + mes + "/" + año, con el objetivo de mostrar la fecha.
	*/
	public static String cambio_mes(int mes, int dia, int año){
    switch(mes){
        case 6:
        case 9:
        case 4:
        case 11:
            dia = 30;
			mes--;
            break;
        case 3:
            if(año_especial(año) == 0){
                dia = 29;
				mes--;
            } else {
                dia = 28;
				mes--;
            }
            break;
        case 1:
            mes = 12;
            dia = 31;
            año--;
            break;
        default:
            dia = 31;
			mes--;
            break;
    }
    return dia + "/" + mes + "/" + año;
	}
	/**
	*Descripcion: método que en cambia el mes y el dia; para generar el día posterior en caso que sea en el mes siguiente.
	*@param int mes debe ser entero, mayores que 1 y menores que 12.
	*@param int dia debe ser entero, mayores que 1 y menore que 31.
	*@param int año debe ser entero y mayores que 2000.
	*@return string dia + "/" + mes + "/" + año, con el objetivo de mostrar la fecha.
	*/
	public static String cambio_mes_posterior(int mes, int dia, int año){
    switch(mes){
        case 6:
        case 9:
        case 4:
        case 11:
            dia = 1;
			mes++;
            break;
        case 2:
            if(año_especial(año) == 0){
                dia = 1;
				mes++;
            } else {
                dia = 1;
				mes++;
            }
            break;
        case 12:
            mes = 1;
            dia = 1;
            año++;
            break;
        default:
            dia = 1;
			mes++;
            break;
    }
    return dia + "/" + mes + "/" + año;
	}
}