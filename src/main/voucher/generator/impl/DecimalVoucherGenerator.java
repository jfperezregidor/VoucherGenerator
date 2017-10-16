package main.voucher.generator.impl;

import main.voucher.generator.VoucherGenerator;

/**
 * Voucher Generator with a code list of Sequential Numbers
 * @author Jeronimo Perez
 * @version 1.0
 */
public class DecimalVoucherGenerator extends VoucherGenerator {

	@Override
	public void generate(int quantity) throws IllegalArgumentException {
		if (quantity > 0) {
			String format = voucherFormat.replace("%s", "");
			for(int i = 0; i<quantity; i++) {
				list.add(String.format(format, i));
			}
		}else{
			throw new IllegalArgumentException("Can't generate vouchers of negative or zero quantities");
		}			
	}

}
