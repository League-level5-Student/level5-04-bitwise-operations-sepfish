package _03_Printing_Binary;

import java.util.ArrayList;

public class BinaryPrinter {
	static // Complete the methods below so they print the passed in parameter in binary.
	// Use bit shifting and bit masking to print the binary numbers.
	// Do not use the Integer.toBinaryString method!
	// Don't be afraid to use the methods that are already complete to finish the
	// others.
	// Create a main method to test your methods.

	boolean isBigger = false;
	int i = 0;
	String answ = "";
	int ans = 0;
	String re = "";
	int twoPow = 0;
	byte subtract = 0;
	int b2 = 0;
	static ArrayList<Integer> powers = new ArrayList<Integer>();
	static ArrayList<Integer> bin = new ArrayList<Integer>();
	static int j = 0;

public void printByteBinary(byte b) { //math competition method
		b2 = b;
		while (b2 > 0) {
			while (!isBigger) {
				byte b3 = (byte) Math.pow(2, i);
				if (b2 - b3 == 0 || b2 - b3 < 0) {
					isBigger = true;
				} else {
					i++;
				}
			}
			if (b2 - Math.pow(2, i) == 0) {
				twoPow = i;
			} else {
				twoPow = i - 1;
			}
			subtract = (byte) Math.pow(2, twoPow);
			ans += (int) Math.pow(10, twoPow);
			i = 0;
			b2 = b2 - subtract;
			isBigger = false;
		}
			System.out.println(b + " in binary is " + ans);
			System.out.println("fact check with " + Integer.toBinaryString(b));
	}

	public void printShortBinary(short s) { //Exploring Computer Science method
		b2 = s;
		while (b2 > 0) {
			if (b2 % 2 == 0) {
				answ += "0";
			} else {
				answ += "1";
			}
			b2 = b2 / 2;
		}
		char[] ansArr = answ.toCharArray();
		for (int i = 0; i < ansArr.length / 2; i++) {
			char c = ansArr[i];
			ansArr[i] = ansArr[ansArr.length - 1 - i];
			ansArr[ansArr.length - 1 - i] = c;
		}
		for (char c : ansArr) {
			re += c;
		}
		System.out.println(s + " in binary is " + re);
		System.out.println("fact check with " + Integer.toBinaryString(s));
	}

	
	public static void printIntBinary(int i) { //_00_Binary_Conversion method
		int victim = i;
		while (!isBigger) {
			int s = (int) Math.pow(2, j);
			if (i - s == 0 || i - s < 0) {
				isBigger = true;
			} else {
				j++;
			}
		}
		for (int i2 = j-1; i2 >= 0; i2--) {
			powers.add((int) Math.pow(2, i2));
		}
		for (Integer g: powers) {
			if (victim - g >= 0) {
				victim -= g;
				bin.add(1);
			} else {
				bin.add(0);
			}
		}
		int answer = 0;
		for (int j = 0; j < bin.size(); j++) {
			answer = answer + bin.get(j) * ((int) Math.pow(10, j+1));
		}
		System.out.println(i + " in binary is " + answer);
		System.out.println("fact check with " + Integer.toBinaryString(i));
	}

	public void printLongBinary(long l) { //I couldn't think of another way
		long b2 = l;
		while (b2 > 0) {
			if (b2 % 2 == 0) {
				answ += "0";
			} else {
				answ += "1";
			}
			b2 = b2 / 2;
		}
		char[] ansArr = answ.toCharArray();
		for (int i = 0; i < ansArr.length / 2; i++) {
			char c = ansArr[i];
			ansArr[i] = ansArr[ansArr.length - 1 - i];
			ansArr[ansArr.length - 1 - i] = c;
		}
		for (char c : ansArr) {
			re += c;
		}
		System.out.println(l + " in binary is " + re);
		System.out.println("fact check with " + Integer.toBinaryString((int) l));
	}

	public static void main(String[] args) {
		BinaryPrinter b = new BinaryPrinter();
		b.printLongBinary(12);
	}

}
