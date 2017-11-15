import java.util.*;
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
		

		char[] baseChars = base.toCharArray();
		char[] removeChars = remove.toCharArray();

		char[] result = new char[baseChars.length];
		char[] buffer = new char[baseChars.length];

		int currentBaseIndex = 0;
		int currentRemoveIndex = 0;
		int resultIndex = 0;
		int bufferIndex = 0;
		
		while (currentBaseIndex < baseChars.length){
			char currentBaseChar = baseChars[currentBaseIndex];
			char currentRemoveChar = removeChars[currentRemoveIndex];

			if (Character.toLowerCase(currentBaseChar) == Character.toLowerCase(currentRemoveChar)){
				currentRemoveIndex++;
				// add to char buffer, in case of an incomplete match and we have to add everything we "removed"
				buffer[bufferIndex] = currentBaseChar;
				bufferIndex++;

				if (currentRemoveIndex == removeChars.length){
					// Word is complete, start checking for new occurrence of word to remove.
					currentRemoveIndex = 0;
					buffer = new char[baseChars.length];
				}
			}
			else if (currentRemoveIndex > 0){
				// flush buffer
				for (int i = 0; i < bufferIndex; i++){
					result[resultIndex] = buffer[i];
					resultIndex++;
				}

				buffer = new char[baseChars.length];
				bufferIndex = 0;
				result[resultIndex] = currentBaseChar;
				resultIndex++;

			}
			else{
				result[resultIndex] = currentBaseChar;
				resultIndex++;
			}

			currentBaseIndex++;


		}


		return new String(result);
	}
}