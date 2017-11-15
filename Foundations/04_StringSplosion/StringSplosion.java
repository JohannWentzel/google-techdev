public class StringSplosion {
	public static void main (String [] args){

		// Boilerplate Java stuff.
		
		if (args.length != 1){
			System.out.println("USAGE: java StringSplosion [word]");
		}
		else{
			System.out.println(stringSplode(args[0]));
		}

	}

	public static String stringSplode(String word){

		String newWord = "";

		// Get the word ready for iteration.
		char[] charArr = word.toCharArray();

		// Iterate through, shifting the end of the substring we're appending to newWord with every iteration.
		for (int i = 0; i < charArr.length; i++){
			newWord += word.substring(0, i + 1);
		}

		return newWord;
	}
}