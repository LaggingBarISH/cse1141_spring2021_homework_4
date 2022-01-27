//This program takes a char "X" as input and prints a diamond shape starting from A to mid X down to A.  
import java.util.Scanner;

public class Pro3 {
	public static void main(String[] args) {
		//take input and check if its 1 char long
		String inputletter=new Scanner(System.in).next();
		if (inputletter.length()!=1) {
			System.out.println("Invalid Input !");
			return;
		}
		char cin = inputletter.toCharArray()[0];
		//Uppercase it
		if((cin>=97) && (cin<=122)) cin-=32;
		//Save the shape to array
		char[][] x =constructDiamond(cin);
		//Print array
		printDiamond(x);
	}
	
	
	//Calculates and writes the shape on an array.
	public static char[][] constructDiamond (char letter) {
		int len = letter-64;
		char[][] array = new char[2*len-1][2*len-1];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				array[i][j]=' ';
			}
		}
		int vertical=0;
		int horizontal=0;
		//Upper half of shape
		for(int i = 0; i<len;i++) {

			for (int j = 0; j < len-1-i; j++) {
				array[vertical][horizontal]=' ';
				horizontal++;
			}

			array[vertical][horizontal]=((char)(i+65));
			horizontal++;

			for (int j = 0; j < 2*i-1; j++) {
				array[vertical][horizontal]=' ';
				horizontal++;
			}

			if (i!=0) {
				array[vertical][horizontal]=((char)(i+65));
				horizontal++;	
			}

			for (int j = 0; j < len-1-i; j++) {
				array[vertical][horizontal]=' ';
				horizontal++;
			}

			horizontal=0;
			vertical++;
		}
		//Lower half of the shape
		for(int i = len-2; i>-1;i--) {

			for (int j = 0; j < len-1-i; j++) {
				array[vertical][horizontal]=' ';
				horizontal++;
			}

			array[vertical][horizontal]=((char)(i+65));
			horizontal++;

			for (int j = 0; j < 2*i-1; j++) {
				array[vertical][horizontal]=' ';
				horizontal++;
			}

			if (i!=0) {
				array[vertical][horizontal]=((char)(i+65));
				horizontal++;	
			}

			for (int j = 0; j < len-1-i; j++) {
				array[vertical][horizontal]=' ';
				horizontal++;
			}

			horizontal=0;
			vertical++;
		}
		return array;
		
	}
	
	//Prints char[][] array.
	public static void printDiamond (char[][] diamond) {
		for (int i = 0; i < diamond.length; i++) {
			for (int j = 0; j < diamond.length; j++) {
				System.out.print(diamond[i][j]);
			}
			System.out.println();
		}
	}

}