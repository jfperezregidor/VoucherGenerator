package main.voucher.generator;

/**
 * Voucher Generator Class
 * @author Jeronimo Perez
 * @version 1.2 
 */
public class VoucherGenerator {
	
	private Algorithm algorithm;
	
	public VoucherGenerator(Algorithm algorithm) {
		this.algorithm = algorithm;
	}
	
	public void generate(int quantity) throws IllegalArgumentException  {
		if (quantity > 0) {
			algorithm.run(quantity);
		}else{
			throw new IllegalArgumentException("Can't generate vouchers of negative or zero quantities");
		}
	}
}
