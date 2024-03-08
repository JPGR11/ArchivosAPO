import java.util.Scanner;

public class Integradora1 {
    
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
		
		//Switches
		
		boolean sw_people = false;
		boolean sw_weight = false;
		boolean sw_plan = false;
		boolean sw_aluggage = false;
		boolean sw_aluggage10 = false;
		String plan_choosen = "";
		String seat = "";
		String seat_xss = "";
		int seat_answer = 0;
		int additional_luggage = 0;
		int additional_luggage23 =0;
		double price_extra_baggage = 0;
		double price_extra_luggage = 0;
		
		//Variables
		
		double luggage_w = 0;
		
		//Menu
		
		menu_message();
		System.out.println("What would you like to do?");
		int option = entrada.nextInt();
		
		switch(option){
			case 1:
			//Verification value is not out of range
		
			while (sw_people == false){
				System.out.println("Are you traveling alone(0) or with friends(1):");
				int passengers = entrada.nextInt();
				sw_people = verification_people(passengers);
			}
			
			if( passengers == 1){
				int n = 4
			} else if(){
				int n = 1
			}
			
			for(int i = 0; i < n; i++){
				//Verification value is not out of the ranges
		
				while (sw_weight == false){
					System.out.println("Great. Approximately, how much weight do you plan to carry on your luggage?");
					luggage_w = entrada.nextDouble();
					entrada.nextLine();
					sw_weight = verification_weight(luggage_w);
				}	
        
				//Choosing plans
		
				System.out.println("We have the perfect plans for you: ");
				System.out.println("------------------------------------------------------------------------------------------------------");
				plans_messages(luggage_w);
		
				//Verification it is the plans mentioned
		
				while (sw_plan == false){
					System.out.println("This plan(s) is(are) perfect for the luggages weight, which plan are you going to choose(lower case)?");
					plan_choosen = entrada.nextLine();
					System.out.println("------------------------------------------------------------------------------------------------------");
					sw_plan = verification_plan(plan_choosen, luggage_w);
				}
		
				//Price so far
		
				double price = plans_price(plan_choosen);
				System.out.println("The price of your ticket so far is: $ " + (int)price);
		
				//Seat
		
				if(plan_choosen.equals("m")){
					System.out.println("Perfect, the M plan lets you choose the location of the seat, do you want it to be at the window, middle or the hall?? (window or hall for $15000 additional)");
					seat = entrada.nextLine();
				} else if(plan_choosen.equals("s") || plan_choosen.equals("xs")){
					System.out.println("Do you want to be able to choose your seat for $50000 additional?(yes(1) or no (0))");
					seat_answer = entrada.nextInt();
				if (seat_answer == 1){
					System.out.println("What seat do you want to go? (window, middle($15000 additional) or hall($ 15000 additional))");
					entrada.nextLine();
					seat_xss = entrada.nextLine();
				}else{
					System.out.println("Great.");
				}
				}
		
				//Price so far with seats
		
				System.out.println("------------------------------------------------------------------------------------------------------");
				double price_seats = seatprice( seat, seat_xss,seat_answer, plan_choosen);
				double price_with_seats = price_seats + price;
				System.out.println("The price so far is: $ " + (int) price_with_seats);
		
				//Additional services
		
				System.out.println("------------------------------------------------------------------------------------------------------");
				System.out.println("Finally, it is possible to get the next additional services: ");
				System.out.println("-Additional luggage of 10 kgs (3 max). $50.000");
				System.out.println("-Additional baggage of 23 (2 max). $100.000");
				System.out.println("------------------------------------------------------------------------------------------------------");
				System.out.println("Do you want to add any of these services? (yes(1) or no (0))");
				int add_services = entrada.nextInt();
				if(add_services == 1){
				System.out.println("Do you want to add extra luggage of 10 kgs? (yes(1) or no (0))");
				int add_extraluggage = entrada.nextInt();
			
				if (add_extraluggage == 1){
				
					while(sw_aluggage10 == false){
						System.out.println("How many extra luggage of 10 kgs do you want to add (max 3 additonal bags)?($ 50000 additional)");
						additional_luggage = entrada.nextInt();
						sw_aluggage10 = verification_luggage(additional_luggage);
					}
				
					price_extra_luggage = luggageprice(add_extraluggage, additional_luggage);
				
				}
				System.out.println("Do you want to add extra luggage of 23 kgs? (yes(1) or no (0))");
				int add_extraluggage23 = entrada.nextInt();
			
				if (add_extraluggage23 == 1){
				
					while(sw_aluggage == false){
						System.out.println("How many extra luggage of 10 kgs do you want to add (max 2 additonal bags)?($ 100000 additional)");
						additional_luggage23 = entrada.nextInt();
						sw_aluggage = verification_luggage23(additional_luggage23);
					}
				
					price_extra_baggage = baggageprice(add_extraluggage23, additional_luggage23);
				
				}
				System.out.println("------------------------------------------------------------------------------------------------------");
				double final_ticket_price = ticket_price(price_seats, price, price_extra_luggage, price_extra_baggage);
				System.out.println("The total price for this ticket is: " + (int) final_ticket_price);
			
				} else if(add_services == 0){
					System.out.println("------------------------------------------------------------------------------------------------------");
					double final_price = price_with_seats;
					System.out.println("The price for this ticket is: $ " + (int) final_price);
				}
			}
			break;
			
			case 2:
			break;
		}
    }
	
	//---------------------------------Weight verification zone----------------------------------------------------------------
	
	/**
	*Description: it verificates what plans can be used according to the weight given.
	*@param double weight.
	*/
	
	public static void plans_messages(double weight){
		String xsinfo = xs();
		String sinfo = s();
		String minfo = m();
		if(weight <= 3 && weight >= 1){
			System.out.println(xsinfo);
			System.out.println(sinfo);
			System.out.println(minfo);
		}else if(weight > 3 && weight <= 13){
			System.out.println(sinfo);
			System.out.println(minfo);
		}else if(weight > 13 && weight <= 36){
			System.out.println(minfo);
		}else if(weight > 36){
			System.out.println(minfo);
			System.out.println("The plans can´t completely cover the weight, so it suggests to get the extra bag service plus the plan M");
		}else{
			System.out.println("Wrong weight value");
		}
		
	}
	
	//-----------------------------------------------------------------------Prices zone----------------------------------------------------------------------------------------------------
	
	/**
	*Description: It calculates the price of the extra luggage.
	*@param int confirm, it is an int number: 1 or 0.
	*@param int qluggage, it is the amount of luggage they want to add, from 1 to 3.
	*@return price.
	*/
	
	public static double luggageprice( int confirm, int qluggage){
		double price = 0;
		if (confirm == 1){
			price = qluggage * 50000;
		}
		return price;
	}
	
	/**
	*Description: It calculates the price of the extra baggage.
	*@param int confirm, it is an int number: 1 or 0.
	*@param int qbaggage, it is the amount of luggage they want to add, from 1 to 2.
	*@return price.
	*/
	
	public static double baggageprice( int confirm, int qbaggage){
		double price = 0;
		if (confirm == 1){
			price = qbaggage * 100000;
		}
		return price;
	}
	
	/**
	*Description: it calculates the price of the seat, in case the user chose it.
	*@param String seat, it has to be hall, window or middle.
	*@param String seatpxss, in this case when the user that chose the xs or s plan decided to add choosing the seat.
	*@param int answer, it has to be an int number: 1 or 0.
	*@param String plan, it is a string: xs, s or m.
	*@return double price.
	*/
	
	public static double seatprice( String seat, String seatpxss, int answer, String plan){
		double price = 0;
		if (plan.equals("xs") || plan.equals("s")){
			if(answer == 1){
				price += 50000;
			}
		}
		if (seatpxss.equals("hall") || seatpxss.equals("window") || seat.equals("window") || seat.equals("hall") ){
			price += 15000;
		}
		return price;
	}
	
	/**
	*Description: it is a method that calculate the prices of each plan.
	*@param String plan, it is a string: xs, s, m.
	*@return price_plan, price of the plan choosen.
	*/
	
	public static double plans_price(String plan){
		double price_plan = 0;
		switch(plan){
			
			case "xs":
			price_plan = 175000;
			break;
			
			case "s":
			price_plan = 175000 + (0.25 * 175000);
			break;
			
			case "m":
			price_plan = 218750 + (0.3 * 218750);
			break;
			
			default:
			System.out.println("Plan not in the system.");
			break;
		}
		return price_plan;
	}
	
	/**
	*Description: It takes all the options chosen and gives the total price.
	*@param double price_seat.
	*@param double price_plan.
	*@param double luggage.
	*@param double baggage.
	*@return double ticket, it returns the price of the chosen options.
	*/
	
	public static double ticket_price(double price_seat, double price_plan, double luggage, double baggage){
		double ticket = 0;
	    ticket += price_seat + price_plan + luggage + baggage;
		return ticket;
	}
	
	//------------------------------------------------------------Verification zone------------------------------------------------------------------------------------------------
	
	/**
	*Description: It verificates that the answer of the first question is alone or with friends.
	*@param int answer, it is an int number: 1 or 0.
	*@return boolean people.
	*/
	
	public static boolean verification_people(int answer){
		boolean people = false;
		if(answer == 0 || answer == 1){
				people = true;
			} else{
				people = false;
			}
		return people;
	}
	
	/**
	*Description: It verificates that the weight is not a negative number.
	*@param double weight.
	*@return boolean wluggage.
	*/
	
	public static boolean verification_weight(double weight){
		boolean wluggage = false;
		if(weight < 1){
				wluggage = false;
			} else{
				wluggage = true;
			}
		return wluggage;
	}
	
	/**
	*Description: It verificates that the answer is one of the plans available and that that the weight fits the plan.
	*@param String plan, it is a string: xs, s or m
	*@param double weight.
	*@return boolean planv.
	*/
	
	public static boolean verification_plan(String plan, double weight){
		boolean planv = false;
		if(plan.equals("xs") || plan.equals("s") || plan.equals("m")){
			planv = true;
		} else if(plan != "xs" || plan != "s" || plan != "m"){
			planv = false;
		} else{
			planv = false;
		}
		
		if (weight > 3 && plan.equals("xs")){
			System.out.println("Max weight was exceeded for this plan.");
			planv = false;
		} else if (weight > 13 && plan.equals("xs")){
			System.out.println("Max weight was exceeded for this plan.");
			planv = false;
		} else if(weight > 13 && plan.equals("s")){
			System.out.println("Max weight was exceeded for this plan.");
			planv = false;
		}
		return planv;
	}
	
	/**
	*Description: it verificates that the amount of baggage is according to the range given.
	*@param int extra_luggage.
	*@return boolean luggage.
	*/
	
	public static boolean verification_luggage23(int extra_luggage){
		boolean luggage = false;
		if(extra_luggage >= 1 && extra_luggage <= 2){
			luggage = true;
		}else{
			luggage = false;
		}
		return luggage;
	}
	
	/**
	*Description: it verificates that the amount of luggage is according to the range given.
	*@param int extra_luggage.
	*@return boolean luggage.
	*/
	
	public static boolean verification_luggage(int extra_luggage10){
		boolean luggage10 = false;
		if(extra_luggage10 >= 1 && extra_luggage10 <= 3){
			luggage10 = true;
		}else{
			luggage10 = false;
		}
		return luggage10;
	}
	
	//--------------------------------------------------------------------------Plan description zone-----------------------------------------------------------------------------------------------------------
	
	/**
	*Descripcion: método que lee con ayuda del escaner la información.
	*@param int cedula, tiene que ser entero
	*/
	
	public static String xs(){
		String xsbenefits = "The plan XS includes a personal item that can be 3 kilograms or less and checking:web/app";
		return xsbenefits;
	}
	
	/**
	*Descripcion: método que lee con ayuda del escaner la información.
	*@param int cedula, tiene que ser entero
	*/
	
	public static String s(){
		String sbenefits = "The plan S includes a personal item that can be 3 kilograms or less, luggage of less than 10 kilograms, win miles to get different prices and checking:web/app";
		return sbenefits;
	}
	
	/**
	*Descripcion: método que lee con ayuda del escaner la información.
	*@param int cedula, tiene que ser entero
	*/
	
	public static String m(){
		String mbenefits = "The plan M includes a personal item that can be 3 kilograms or less, luggage of  10 kilograms or less, baggage of 23 kilograms or less, win miles to get different prices, being able to choose the seat and checking:web/app";
		return mbenefits;
	}
	
	//----------------------------------------------------Messages----------------------------------------------------------------
	
	public static void menu_message(){
		System.out.println("-----Welcome to Icesi's trips planner-----");
		System.out.println("----------------Menu-----------------------");
		System.out.println("(1) --> Plan trip.");
		System.out.println("(2) --> See last 10 trips price.");
		System.out.println("(3) --> Most expensive trip of the last 10.");
		System.out.println("--------------------------------------------");
	}
}
