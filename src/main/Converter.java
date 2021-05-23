package main;
import java.util.Scanner;
public class Converter {
	public static void main (String[] agrs) {
		Converter v1 = new Converter("Cups","Teaspoons", 48);
		Converter v2 = new Converter ("Ounce","Liters", 0.02957353);
		Converter v3 = new Converter ("Ounce","Mililiter",29.5735296);
		Converter d1 = new Converter ("Miles","Kilometers",1.609344);
		Converter d2 = new Converter ("Feet","Meters",0.3048);
		Converter d3 = new Converter ("Yard","Meter",0.9144);
		Converter w1 = new Converter ("Pounds","Kilograms",0.45359237);
		Converter w2 = new Converter ("Ounce", "Gram", 28.3495231);
		Converter w3 = new Converter ("US quintal","Kilograms", 45.359237);
		Converter[][] menuOrder = {{v1,v2,v3},{d1,d2,d3},{w1,w2,w3}};
		
		
		mainMenu();
		System.out.print("Your Answer: ");
		int menuSelection;
		Scanner scan = new Scanner (System.in);
		menuSelection = scan.nextInt();
		while (menuSelection != 4) {			
			switch(menuSelection) {
				case 1: {
					Level2(menuOrder[0], scan);
					break;
				}
				case 2: {
					Level2(menuOrder[1], scan);
					break;
				}
				case 3: {
					Level2(menuOrder[2], scan);
					break;
				}
				case 4:{
					break;
				}
				default: {
					System.out.println("Input is not valid. Please try again!");		
				}
			}
			mainMenu();
			System.out.print("Your Answer: ");
			menuSelection = scan.nextInt();
		}
		System.out.println("**************************************************************************");
		System.out.println("Thank you for using this program! See you next time!");
		scan.close();
	}
	
	private String unit1;
	private String unit2;
	private double ratio; 
	public Converter (String u1, String u2, double r) {
		unit1 = u1;
		unit2 = u2;
		ratio = r;
	}
	public void collectQuantity( Scanner scan) {
		printBorder();
		System.out.print("Please insert amount of "+unit1 + " you want to convert:");
		double input;
		try {
			input= scan.nextDouble();
			System.out.print("Result: ");
			System.out.println(input + " "+ this.unit1 + " = " + input*this.ratio + " " + this.unit2 );
		}
		catch (java.util.InputMismatchException e) {
			System.out.println("Input is not valid. Please try again!");
//			collectQuantity ( scan );
		}
	}
	public void title() {
		System.out.println(unit1 + " to " +unit2);
	}
	public void printBorder() {
		System.out.println("**************************************************************************");
	}
	
	/////
	public static void mainMenu() {
		System.out.println("*******************************MAIN MENU**********************************");
		System.out.println("Please select an option");
		System.out.println("1. Volumn");
		System.out.println("2. Distance");
		System.out.println("3. Mass");
		System.out.println("4. Quit");
	}
	
	public static void listingOrder(Converter[] converters) {
		System.out.println("**************************************************************************");
		System.out.println("Please sellect an option");
		for (int i=0; i<converters.length; i++) {
			Converter v = converters[i];
			System.out.print((i+1)+". ");
			v.title();
		}
		System.out.println("4. Back");
		System.out.print("Your Answer: ");
	}
	
	///// menu level 2
	public static void Level2 (Converter[] converters, Scanner scan) {
		listingOrder(converters);
		int option;
		option = scan.nextInt();
		while ( option != 4 ) {			
			switch ( option ) {
				case 1:	{
					converters[0].collectQuantity(scan);
					boolean isContinue = isContinue(scan);
					if (isContinue) {
						continue;
					}
					break;
				}
				case 2:	{
					converters[1].collectQuantity(scan);
					boolean isContinue = isContinue(scan);
					if (isContinue) {
						continue;
					}
					break;
				}
				case 3:	{
					converters[2].collectQuantity(scan);
					boolean isContinue = isContinue( scan );
					if (isContinue) {
						continue;
					}
					break;
				}
				case 4: {
					break;
				}
				default:{
					System.out.println("Invalid value! Please try agian!");
					break;
				}
			}
			listingOrder(converters);
			option = scan.nextInt();
				
		}
	}
	
	///continue menu
	
	public static boolean isContinue( Scanner scan ) {
		int option; 
		do {
			System.out.println("**************************************************************************");
			System.out.println("Do you want to continue?");
			System.out.println("1. Yes, convert another number");
			System.out.println("2. No, go back");
			System.out.print("Your Answer: ");
			option = scan.nextInt();
			switch(option) {
				case 1: {
					return true;
				}
				case 2: {
					break;
				}
				default: {
					
					System.out.println("Invalid value! Please try agian!");
				}
			}
		}
		while(option!=2);
		
		
		
		
		
//		System.out.println("**************************************************************************");
//		System.out.println("Do you want to continue?");
//		System.out.println("1. Yes, convert another number");
//		System.out.println("2. No, go back");
//		int option; 
//		option = scan.nextInt();
//		while (option!=2) {
//			switch(option) {
//				case 1: {
//					return true;
//				}
//				case 2: {
//					break;
//				}
//				default: {
//					
//					System.out.println("Invalid value! Please try agian!");
//				}
//			}
//			System.out.println("**************************************************************************");
//			System.out.println("Do you want to continue?");
//			System.out.println("1. Yes, convert another number");
//			System.out.println("2. No, go back");
//			option = scan.nextInt();
//		}
		return false;
	}
}


