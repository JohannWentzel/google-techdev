import java.lang.*;

public class WithoutString{
	public static void main(String[] args) {
		if (args.length == 2){
			System.out.println(withoutString(args[0],args[1]));
		}
		else{
			System.out.println("USAGE: java WithoutString [base string] [string to remove]");
		}
	}

	public static String withoutString(String base, String remove){
		
		// GENERAL STRATEGY: Go through the array, tracking which character we're looking at.
		// If we find a match, keep stepping through and making sure the characters match.
		// We only add items to the final result when they DON'T match, so we need a buffer
		// that will add the characters of an incomplete match to the final result.


		char[] baseChars = base.toCharArray();
		char[] removeChars = remove.toCharArray();

		StringBuilder result = new StringBuilder();
		StringBuilder buffer = new StringBuilder();

		int currentBaseIndex = 0;
		int currentRemoveIndex = 0;

		// step through the base string
		
		while (currentBaseIndex < baseChars.length){


			char currentBaseChar = baseChars[currentBaseIndex];
			char currentRemoveChar = removeChars[currentRemoveIndex];


			if (Character.toLowerCase(currentBaseChar) == Character.toLowerCase(currentRemoveChar)){
				// if there's a match, we increment the Remove Index so the next iteration will track
				// the next character in the word to be removed.
				currentRemoveIndex++;

				// add to char buffer, in case of an incomplete match and we have to add everything we thought was a match
				buffer.append(currentBaseChar);

				if (currentRemoveIndex == removeChars.length){
					// Word is complete. Clear the buffer, reset the index, 
					// start checking for new occurrence of word to remove.
					currentRemoveIndex = 0;
					buffer = new StringBuilder();
				}
			}
			else if (currentRemoveIndex > 0){

				// Add what we had in the buffer to the final result. Not removed from the string.
				result.append(buffer.toString());
				buffer = new StringBuilder();

				currentRemoveIndex = 0;

				result.append(currentBaseChar);	

			}
			else{
				// No match.
				result.append(currentBaseChar);	
			}

			currentBaseIndex++;

		}

		// If there's anything left over in the buffer, add it to the end of the result.
		if (buffer.toString().length() > 0){
			result.append(buffer.toString());
		}


		return result.toString();
	}
}