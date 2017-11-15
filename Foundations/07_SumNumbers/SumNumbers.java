import java.lang.*;

public class SumNumbers {
	public static void main(String[] args) {
		if (args.length == 1){
			System.out.println(sumNumbers(args[0]));
		}
	}

	public static int sumNumbers(String str){

		int totalSum = 0;

		// if we find a digit, we start checking anything past it to see what number it's in.
		int beginNumIndex = 0;
		// our indication that we're midway through parsing a number
		boolean currentlyNumber = false;

		// The program makes one sweep through the string, so we're in O(n) time.
		for (int i = 0; i < str.length(); i++){

			// If we find a digit, we go forward knowing we're parsing a number.
			if ((Character.isDigit(str.charAt(i))) && !currentlyNumber){
				currentlyNumber = true;
				beginNumIndex = i;
			}

			// Once that number ends, we parse it out of the string, and
			// add it to the total sum.
			else if (!Character.isDigit(str.charAt(i)) && currentlyNumber){
				currentlyNumber = false;
				String numberSubstring = str.substring(beginNumIndex, i);
				totalSum = totalSum + Integer.parseInt(numberSubstring);
			}
		}

		// if a number made up the end of the string, we parse that too.
		if (currentlyNumber){
			String numberSubstring = str.substring(beginNumIndex, str.length());
			totalSum = totalSum + Integer.parseInt(numberSubstring);
		}

		return totalSum;

	}
}