package main;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import main.voucher.generator.Algorithm;
import main.voucher.generator.VoucherGenerator;
import main.voucher.generator.impl.Decimal;
import main.voucher.generator.impl.Hexadecimal;
import main.voucher.generator.impl.HexadecimalRandom;

/**
 * Voucher Generator Program
 * @author Jeronimo Perez
 * @version 1.2
 */
public class Main {

	private static Scanner keyboard;

	public static void main(String[] args) {
		
		Map<String, Algorithm> algorithms = new HashMap<String, Algorithm>();
		
		algorithms.put("decimal", new Decimal());
		algorithms.put("hexadecimal", new Hexadecimal());
		algorithms.put("random", new HexadecimalRandom());
		
		keyboard = new Scanner(System.in);
		
		System.out.println("--- Voucher Generator Program ---");
		System.out.println("\n" + "Voucher Generator Types:\n"
				+ "		decimal - Sequential decimal\n" 
				+ "		hexadecimal - Sequential hexadecimal\n" 
				+ "		random - Random filled hexadecimal\n");

		try {
			System.out.print("Please, enter generator type:");
			String type = keyboard.next().toLowerCase();
			
			System.out.print("Please, enter quantity:");
			int quantity = keyboard.nextInt();
			
			VoucherGenerator vg = new VoucherGenerator(algorithms.get(type));
			vg.generate(quantity);
			
		} catch (NullPointerException e) {
			System.out.println("The specified algorithm is undefined. Please reset the program.");
		} catch (InputMismatchException e) {
			System.out.println("Error, please only insert numbers. Please reset the program.");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage() + ". Please reset the program.");
		} 
		
		System.out.println("---   End   ---");
		
	}

}