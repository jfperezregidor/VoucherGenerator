package main.voucher.generator;

public interface Algorithm {
	
	/**
	 * Generate list of codes
	 * @param quantity - number of voucher
	 * @throws IllegalArgumentException - quantity must be greather than 0
	 */
	 void run(int quantity);
	
}
