package main;

import java.util.InputMismatchException;
import java.util.Scanner;

import main.exceptions.AlgorithmException;
import main.voucher.generator.VoucherGenerator;

/**
 * Voucher Generator Program
 * @author Jeronimo Perez
 * @version 1.1
 */
public class Main {

	private static Scanner keyboard;

	public static void main(String[] args) {
		keyboard = new Scanner(System.in);
		System.out.println("--- Voucher Generator Program ---");
		System.out.println("\n" + "Voucher Generator Types:\n" + "		0 - Sequential numbers\n" + "		1 - Sequential hexadecimal\n" + "		2 - Random filled hexadecimal\n");

		try {
			// Init the generator entries
			System.out.print("Please, enter generator type:");
			int type = keyboard.nextInt();
			System.out.print("Please, enter quantity:");
			int quantity = keyboard.nextInt();

			//Define VoucherGenerator
			VoucherGenerator voucherGenerator = VoucherGenerator.getVoucherGenerator(type);
			voucherGenerator.generate(quantity);

			System.out.println("\n---   Creating voucher generator...   ---");

			//Printing results
			for (String code: voucherGenerator.getCodes()) {
				System.out.println(code);
			}
			
		} catch (InputMismatchException e) {
			System.out.println("Error, please only insert numbers. Please reseat the program.");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage() + ". Please reseat the program.");
		} catch (AlgorithmException e) {
			System.out.println(e.getMessage() + ". Please reseat the program.");
		}

		System.out.println("---   End   ---");
	}

}