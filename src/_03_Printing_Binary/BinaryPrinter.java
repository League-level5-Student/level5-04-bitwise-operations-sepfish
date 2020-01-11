package _03_Printing_Binary;

public class BinaryPrinter {
	//Complete the methods below so they print the passed in parameter in binary.
	//Use bit shifting and bit masking to print the binary numbers.
	//Do not use the Integer.toBinaryString method!
	//Don't be afraid to use the methods that are already complete to finish the others.
	//Create a main method to test your methods.
	
	boolean isBigger = false;
	int i = 0;
	
	int isBigger(int a, int b) {
		while (!isBigger) {
			byte b2 = (byte) Math.pow(2, i);
			if (b - b2 < 0) {
				isBigger = true;
			} else {
				i++;
			}
		}
		return i;
	}
	
	public void printByteBinary(byte b) {
		//check for powers of 2
		while (!isBigger) {
			byte b2 = (byte) Math.pow(2, i);
			if (b - b2 == 0) {
				System.out.println((int) Math.pow(10, i));
				isBigger = true;
			} else if (b - b2 < 0) {
				isBigger = true;
			} else {
				i++;
			}
		}
		//other stuff
		int num = 0;
		while (b > 0) {
			byte b2 = (byte) Math.pow(2, i);
			int g = isBigger(b, b2);			
		}
		
		
	}
	
	public void printShortBinary(short s) {
		
	}
	
	public void printIntBinary(int i) {
		
	}
	
	public void printLongBinary(long l) {
		
	}
	
	public static void main(String[] args) {
		BinaryPrinter b = new BinaryPrinter();
		b.printByteBinary((byte) 8);
	}
}
