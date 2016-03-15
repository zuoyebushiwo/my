package com.company.jm;

public class EquityNumber {

	public static void main(String[] args) {
		
		boolean isEquityNumber = isEquityNumber(3443);
		System.out.println(isEquityNumber);
	}

	public static boolean isEquityNumber(int number) {
		String numStr = String.valueOf(number);
		if (numStr.length() == 1) {
			return true;
		}
		
		if (numStr.length() % 2 == 0) {
			String front = numStr.substring(0, numStr.length() / 2);
			String end = numStr.substring(numStr.length() / 2, numStr.length());
			
			byte[] bytes = end.getBytes();
			byte[] newBytes = new byte[bytes.length];
			for (int i = 0; i < newBytes.length; i++) {
				newBytes[i] = bytes[bytes.length - i - 1];
			}
			
			String reserseEnd = new String(newBytes);
			
			if (front.equals(reserseEnd)) {
				return true;
			}
		}
		
		return false;
	}
	
}
