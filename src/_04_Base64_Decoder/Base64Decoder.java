package _04_Base64_Decoder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Base64Decoder {
	/*
	 * Base 64 is a way of encoding binary data using text.
	 * Each number 0-63 is mapped to a character. 
	 * NOTE: THIS IS NOT THE SAME AS ASCII OR UNICODE ENCODING!
	 * Since the numbers 0 through 63 can be represented using 6 bits, 
	 * every four (4) characters will represent twenty four (24) bits of data.
	 * 4 * 6 = 24
	 * 
	 * For this exercise, we won't worry about what happens if the total bits being converted
	 * do not divide evenly by 24.
	 * 
	 * If one char is 8 bits, is this an efficient way of storing binary data?
	 * (hint: no)
	 * 
	 * It is, however, useful for things such as storing media data inside an HTML file (for web development),
	 * so that way a web site does not have to look for an image, sound, library, or whatever in a separate location.
	 * 
	 * View this link for a full description of Base64 encoding
	 * https://en.wikipedia.org/wiki/Base64
	 */
	
	
	final static char[] base64Chars = {
		'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 
		'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
		'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
		'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'
	};
	
	//1. Complete this method so that it returns the the element in
	//   the base64Chars array that corresponds to the passed in char.
	public static byte convertBase64Char(char c){
		for (int i = 0; i < base64Chars.length; i++) {
			if (c == base64Chars[i]) {
				return (byte) i;
			}
		}
			return 0;
	}
	
	/* Decoding code
	 * 	int[] binary = {0, 0, 0, 0, 0, 0, 0, 0};
		String a = "";
		int ans = 0;
		String b = Integer.toBinaryString((int) c);
		System.out.println(c);
		System.out.println(b);
		for (int j = (binary.length - b.length()); j < binary.length; j++) {
			binary[j] = Integer.parseInt(String.valueOf(b.charAt(j-1)));
		}
		for (int i: binary) {
			System.out.print(i);
		}
		System.out.println();
		for (int k = 0; k < 6; k++) {
			String s = String.valueOf(binary[k]);
			a = a.concat(s);
			if (s.equals("1")) {
				ans += (int) Math.pow(2, 6-k-1);
			}
		}
		System.out.println(a);
		System.out.println(ans);
	 */
	
	//2. Complete this method so that it will take in a string that is 4 
	//   characters long and return an array of 3 bytes (24 bits). The byte 
	//   array should be the binary value of the encoded characters.
	public static byte[] convert4CharsTo24Bits(String s){
		String[] sChar = new String[s.length()];
		for (int i = 0; i < s.length(); i++) {
			sChar[i] = Integer.toBinaryString(convertBase64Char(s.charAt(i)));
			while(sChar[i].length() < 6) {
				sChar[i] = "0" + sChar[i];
			}
		}
		String bigString = "";
		String byte1 = "";
		String byte2 = "";
		String byte3 = "";
		int b1 = 0;
		int b2 = 0;
		int b3 = 0;
		for (String st: sChar) {
			bigString += st;
		}
		byte1 = bigString.substring(0, 8);
		byte2 = bigString.substring(8, 16);
		byte3 = bigString.substring(16, 24);
		for (int i = 0; i < 8; i++) {
			b1 += (int) Math.pow(2, i) * Integer.parseInt(String.valueOf(byte1.charAt(7-i)));
			b2 += (int) Math.pow(2, i) * Integer.parseInt(String.valueOf(byte2.charAt(7-i)));
			b3 += (int) Math.pow(2, i) * Integer.parseInt(String.valueOf(byte3.charAt(7-i)));
		}
		return new byte[] {(byte) b1, (byte) b2, (byte) b3};
	}
	
	//3. Complete this method so that it takes in a string of any length
	//   and returns the full byte array of the decoded base64 characters.
	public static byte[] base64StringToByteArray(String file) {
		ArrayList<String> sChar = new ArrayList<String>();
		for (int i = 0; i < file.length(); i++) {
			sChar.add(Integer.toBinaryString(convertBase64Char(file.charAt(i))));
			while(sChar.get(i).length() < 6) {
				sChar.set(i, "0" + sChar.get(i));
			}
		}
		String bigString = "";
		for (String s: sChar) {
			bigString += s;
		}
		byte[] arr = new byte[sChar.size()];
		for (int i = 0; i < bigString.length()/8-1; i++) {
			String byte1 = "";
			int b1 = 0;
			byte1 = bigString.substring(8*i, 8*i+8);
			for (int j = 0; j < 8; j++) {
				b1 += (int) Math.pow(2, j) * Integer.parseInt(String.valueOf(byte1.charAt(7-j)));
			}
			arr[i] = (byte) b1;
		}
		return arr;
	}
}
