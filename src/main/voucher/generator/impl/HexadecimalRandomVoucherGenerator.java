package main.voucher.generator.impl;

import java.util.Random;

import main.voucher.generator.VoucherGenerator;


/**
 * Voucher Generator with a code list of Hexadecimal Numbers with minimum 6 characters
 * @author Jeronimo Perez
 * @version 1.0
 */
public class HexadecimalRandomVoucherGenerator extends VoucherGenerator {
	
	private static final int numDigits = 7;

	@Override
	public void generate(int quantity) throws IllegalArgumentException {
		if (quantity > 0 && String.valueOf(quantity).length() < HexadecimalRandomVoucherGenerator.numDigits) {	
			while(list.size() < quantity) {
				int init = 0;
				int end = Integer.valueOf(new String(new char[numDigits + 1]).replace('\0', '9'));
				String num = Integer.toHexString(new Random().nextInt(end) + init);
				if(!list.contains(String.format(voucherFormat,0, num).substring(num.length()))) {
					list.add(String.format(voucherFormat,0, num).substring(num.length()));
				}
			}
			
		}else{
			throw new IllegalArgumentException("The hexadecimal random only can be used quantities less than 1.000.000 and greater than 0");
		}		
	}

}
