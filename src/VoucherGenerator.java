import java.util.ArrayList;
import java.util.Random;

/**
 * Voucher Generator Class
 * @author Jeronimo Perez
 * @version 1.0 
 */
public class VoucherGenerator {
	
	public static int DECIMAL_SEQUENTIAL = 0;
	public static int HEXADECIMAL_SEQUENTIAL = 1;
	public static int HEXADECIMAL_FILLED = 2;
	
	private int numDigits = 6;
	private String voucherFormat = "%06d%s";
	
	private int type = 0;
	private int quantity = 0;
	private ArrayList<String> codes = new ArrayList<>();
	
	
	/**
	 * Voucher Generator Constructor
	 * @return type - Generator type (0,1,2)
	 * @param quantity - Voucher codes number
	 * @throws Exception Appear if the type is undefined
	 */
	public VoucherGenerator(int type, int quantity) throws Exception {
		this.type = type;
		
		if(quantity > 0) {
			this.quantity = quantity;
			generateCodes(this.type, this.quantity);
		}else {
			throw new IllegalArgumentException("The quantity must be greater than zero" );
		}
		
	}
	
	/**
	 * Create de list of codes
	 * @return type - Generator type (0,1,2)
	 * @param quantity - Voucher codes number
	 * @throws Exception - Generator type undefined 
	 */
	private void generateCodes(int type, int quantity) throws Exception{
		
		this.codes = new ArrayList<String>();
		checkFormat(quantity);
		
		switch (type) {
			case 0:
				this.codes = decimalSequencialGenerator(quantity);
				break;
			case 1:
				this.codes = hexadecimalSequencialGenerator(quantity);
				break;
			case 2:
				this.codes = hexadecimalFilledGenerator(quantity);
				break;
			default:
				throw new Exception("Generator type (" + type +") is undefined");
				//System.out.println("Error! You must to define a correct voucher generator type. Please, reset the program.");
		}
		
	}
	
	/**
	 * Check the String format depends on the length of quantity
	 * @param quantity - Voucher codes number
	 */
	private void checkFormat(int quantity) {
		if (String.valueOf(quantity-1).length() > this.numDigits) {
			this.numDigits = String.valueOf(quantity).length();
			this.voucherFormat = "%0" + this.numDigits + "d%s";
		}
	}
	
	
	/**
	 * Voucher code list of Sequential Numbers
	 * @param quantity - Voucher codes number
	 * @return list - voucher code list 
	 */
	private ArrayList<String> decimalSequencialGenerator(int quantity){
		ArrayList<String> list = new ArrayList<String>();
		String format = voucherFormat.replace("%s", "");
		for(int i = 0; i<quantity; i++) {
			list.add(String.format(format, i));
		}
		return list;
	}
	
	/**
	 * Voucher code list of Sequential Hexadecimal numbers
	 * @param quantity - Voucher codes number
	 * @return list - voucher code list 
	 */
	private ArrayList<String> hexadecimalSequencialGenerator(int quantity){
		ArrayList<String> list = new ArrayList<String>();
			
		for(int i = 0; i<quantity; i++) {
			String num = Integer.toHexString(i);
			list.add(String.format(voucherFormat,0, num).substring(num.length()));
		}
		return list;
	}
	
	/**
	 * Voucher code list create in hexadecimal and 6 characters minimum will be filled
	 * @param quantity - voucher codes number
	 * @return list - voucher code list 
	 */
	private ArrayList<String> hexadecimalFilledGenerator(int quantity){
		ArrayList<String> list = new ArrayList<String>();
		if(String.valueOf(quantity).length() >= this.numDigits) {
			list = hexadecimalSequencialGenerator(quantity);
		}else{
			while(list.size() < quantity) {
				int init = 0;
				int end = Integer.valueOf(new String(new char[this.numDigits + 1]).replace('\0', '9'));
				String num = Integer.toHexString(new Random().nextInt(end) + init);
				if(!list.contains(String.format(voucherFormat,0, num).substring(num.length()))) {
					list.add(String.format(voucherFormat,0, num).substring(num.length()));
				}
			}
		}
		return list;
	}


	/**
	 * Get type
	 * @return type - Generator type (0,1,2)
	 */
	public int getType() {
		return type;
	}

	/**
	 * Set type
	 * @param type - Generator Type (0,1,2)
	 * @throws Exception - Generator type undefined 
	 */
	public void setType(int type) throws Exception {
		this.type = type;
		generateCodes(this.type, this.quantity);
	}

	/**
	 * Generator quantity
	 * @return quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Set quantity
	 * @param quantity
	 * @throws Exception - Generator type undefined 
	 */
	public void setQuantity(int quantity) throws Exception {
		if(quantity > 0) {
			this.quantity = quantity;
			generateCodes(this.type, this.quantity);
		}else {
			throw new IllegalArgumentException("The quantity must be greater than zero" );
		}
	}

	/**
	 * List of voucher codes
	 * @return codes
	 */
	public ArrayList<String> getCodes() {
		return codes;
	}
	
	
}
