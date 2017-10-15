import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Voucher Generator Program
 * @author Jeronimo Perez
 * @version 1.0
 */
public class Main {
	
	private static VoucherGenerator voucherGenerator;
	private static Scanner keyboard;
	public static void main(String[] args) {
		keyboard = new Scanner(System.in);
		System.out.println("--- Voucher Generator Program ---");
		System.out.println("\n"
				+ "Voucher Generator Types:\n"
				+ "		0 - Sequential numbers\n"
				+ "		1 - Sequential hexadecimal\n"
				+ "		2 - Filled hexadecimal\n");
		
		try {
			// Init the generator entries
			System.out.print("Please, enter generator type:");
			int type = keyboard.nextInt();
			System.out.print("Please, enter quantity:");
			int quantity = keyboard.nextInt();

			System.out.println("\n---   Creating voucher generator...   ---");
			// Voucher Generator
			voucherGenerator = new VoucherGenerator(type, quantity);
			
			// Get List of codes
			ArrayList<String> codes = voucherGenerator.getCodes();
			
			// Print the results
			if(!codes.isEmpty()) {
				System.out.println("---   Results  ---");
				printCodes(codes);
			}
		}catch(InputMismatchException e) {
			// Inputs error
			System.out.println("Error, please only insert numbers. Reset the program and start again.");
		}catch(IllegalArgumentException e) {
			// Error, Quantity must be greater than 0
			System.out.println("The quantity must be greater than zero. Reset the program and start again.");
		}catch (Exception e) {
			// Error, Generator type is undefined
			System.out.println("Error! Generator type is wrong. Please reset the program and enter the correct type.");
		}
		
		System.out.println("---   End   ---");
	}
	
	
	/**
	 * Print a codes list from voucher generator
	 * @param codes
	 */
	private static void printCodes(ArrayList<String> codes) {
		for(String code: codes) {
			System.out.println(code);
		}
	}

}
