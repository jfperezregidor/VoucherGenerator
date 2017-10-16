package main.voucher.generator;

import java.util.ArrayList;

import main.exceptions.AlgorithmException;
import main.voucher.generator.impl.DecimalVoucherGenerator;
import main.voucher.generator.impl.HexadecimalRandomVoucherGenerator;
import main.voucher.generator.impl.HexadecimalVoucherGenerator;

/**
 * Voucher Generator Class
 * @author Jeronimo Perez
 * @version 1.1 
 */
public abstract class VoucherGenerator {
	
	protected String voucherFormat;
	protected ArrayList<String> list;

	
	/**
	 * Voucher Generator Constructor
	 */
	protected VoucherGenerator() {
		this.voucherFormat = "%06d%s";
		this.list = new ArrayList<String>();
	}
	
	/**
	 * List of voucher codes
	 * @return codes list
	 */
	public ArrayList<String> getCodes() {
		return list;
	}
	

	/**
	 * Get Voucher Generator
	 * @param type - Generator Type
	 * @return VoucherGenerator 
	 * @throws AlgorithmException
	 */
	public static VoucherGenerator getVoucherGenerator(int type) throws AlgorithmException {
		switch (type) {
			case 0: return new DecimalVoucherGenerator();
			case 1: return new HexadecimalVoucherGenerator();
			case 2: return new HexadecimalRandomVoucherGenerator();
			default: throw new AlgorithmException("Can't generate vouchers with an undefined algorithm");
		}
	}
	
	/**
	 * Generate list of codes
	 * @param quantity - number of voucher
	 * @throws IllegalArgumentException - quantity must be greather than 0
	 */
	public abstract void generate(int quantity) throws IllegalArgumentException;
}
