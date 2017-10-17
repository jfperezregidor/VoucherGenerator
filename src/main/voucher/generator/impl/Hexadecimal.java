package main.voucher.generator.impl;

import main.voucher.generator.Algorithm;

/**
 * Voucher Generator with a code list of Hexadecimal Sequential Numbers
 * @author Jeronimo Perez
 * @version 1.1
 */
public class Hexadecimal implements Algorithm {
	
	private static final String voucherFormat = "%06d%s";

	@Override
	public void run(int quantity) {
		for(int i = 0; i<quantity; i++) {
			String num = Integer.toHexString(i);
			System.out.println(String.format(voucherFormat,0, num).substring(num.length()));
		}
	}
}
