package main.voucher.generator.impl;

import main.voucher.generator.Algorithm;

/**
 * Voucher Generator with a code list of Sequential Numbers
 * @author Jeronimo Perez
 * @version 1.1
 */
public class Decimal implements Algorithm {
	
	private static final String voucherFormat = "%06d%s";

	@Override
	public void run(int quantity)  {
		String format = voucherFormat.replace("%s", "");
		for(int i = 0; i<quantity; i++) {
			System.out.println(String.format(format, i));
		}
	}

}
