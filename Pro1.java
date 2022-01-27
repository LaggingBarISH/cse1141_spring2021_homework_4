//This program calculates bills per flat proportional to spent amount.
import java.util.Scanner;

public class Pro1 {
	public static void main(String[] args) {
		//Parse inputs
		//------------------------------------------------------------------------------------------
		Scanner _scanner = new Scanner(System.in);
		int len=_scanner.nextInt();
		double[] usage = new double[len];
		for (int i=0;i< len;i++)
			usage[i]= _scanner.nextDouble();
		double totalbill = _scanner.nextDouble();
		//------------------------------------------------------------------------------------------
		double[] bills = calculateTheInvoice(usage, totalbill); //Calculates invoice
		printBills(bills);
	}
	//I don't know why are we being forced to use predefined functions.
	//Excellent way to detect cheaters after last homework had ~23 cheaters. Many of which were false positive. And mails stating why there could be extreme similarities between people's codes were ignored.  
	public static double[] calculateTheInvoice (double[] flats, double totalBill)
	{
		//take 30 and 70 percentages.
		double shared = totalBill*3/10; 
		double personal=totalBill*7/10;
		//Calculates the bill for each flat.
		double[] bills = new double[flats.length];
		for (int i = 0;i< flats.length;i++)
			bills[i]=shared/flats.length+(flats[i]/addArray(flats))*personal;
		return bills;
	}
	//Prints the calculated bill for each flat.
	//Why are we still using *100/100.0 and not printf .2f ??? 
	public static void printBills (double[] bills)
	{
		for (int i=0; i< bills.length;i++)
			System.out.println("Flat #"+(i+1)+": " + (int)(bills[i]*100)/100.0);
		return;
	}
	//Sums values from an array.
	public static double addArray(double[] array) {
		double val = array[0];
		for(int i=1; i< array.length;i++) {
			val += array[i];
		}
		return val;
	}
}