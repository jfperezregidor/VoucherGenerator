package main.voucher.generator.impl;

import main.voucher.generator.VoucherGenerator;

/**
 * Voucher Generator with a code list of Hexadecimal Sequential Numbers
 * @author Jeronimo Perez
 * @version 1.0
 */
public class HexadecimalVoucherGenerator extends VoucherGenerator {

	@Override
	public void generate(int quantity) throws IllegalArgumentException {
		if (quantity > 0) {
			for(int i = 0; i<quantity; i++) {
				String num = Integer.toHexString(i);
				list.add(String.format(voucherFormat,0, num).substring(num.length()));
			}
		}else{
			throw new IllegalArgumentException("Can't generate vouchers of negative or zero quantities");
		}
	}
}
