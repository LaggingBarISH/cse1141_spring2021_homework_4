//This program check if a number follows given code "checksum".
import java.util.Scanner;

public class Pro2 {
	static boolean ignore=false;
	public static void main(String[] args) {
		//Checks number
		String _scanner = new Scanner(System.in).nextLine();
		
		if(validateNumber(_scanner)) {
			if(ignore) return;
			System.out.println("Number is Valid");
			return;
		}
		else {
			if(ignore) return;
			System.out.println("Number is Invalid");
		}
	}
	
	//Ah yes another crippled example of defining which and how methods should be used.
	//I have 3 possible outcomes here and the method returns a bool value. Notice the problem yet?
	public static boolean validateNumber (String number) {
		//Check if number
		char[] validchars= {'0','1','2','3','4','5','6','7','8','9',' ','_'};
		int x=number.length();
		for(int i = 0;i<number.length();i++)
			if (number.toCharArray()[i]==' ') x--;
		int[] newnumber = new int[x];
		int count=0;
		//turns string to int[]
		for (int i = 0; i < newnumber.length; i++) {
			newnumber[i]=11;
			for (int j = 0; j < 11; j++) {
				if(number.toCharArray()[i+count]==validchars[j]) {
					newnumber[i]=j;
					if (j==10) {
						newnumber[i]=0;
						count++;i--;
					}
				}
			}
			//Has non numerical input
			if (newnumber[i]==11) {
				System.out.println("Invalid Input !");
				ignore=true;
				return false;
			}
		}

		int totalcount=0;
		//Formatting printing.
		//Calculating
		int[] printthisfirst= new int[newnumber.length];
		int[] printthislater= new int[newnumber.length];
		for (int j = 0; j < newnumber.length; j++) {
			totalcount += newnumber[j];
			printthisfirst[j]=11;
			printthislater[j]=newnumber[j];
		}
		
		for (int i = newnumber.length-1; i > 0; i-=2) {
			totalcount += newnumber[i-1];
			printthisfirst[i-1]=newnumber[i-1];
			printthislater[i-1]+=newnumber[i-1];
			if (newnumber[i-1]>4) {
				totalcount -= 9;
				printthislater[i-1]-=9;
			}
		}
		
		for(int i=0;i<printthisfirst.length;i++) {
			System.out.print(validchars[printthisfirst[i]]);
		}
		System.out.println();
		for(int i=0;i<printthisfirst.length;i++) {
			System.out.print(validchars[printthislater[i]]);
		}
		System.out.println();
		
		//Multiple of 10 or not.
		if(totalcount%10!=0) return false;
		return true;
	}


}