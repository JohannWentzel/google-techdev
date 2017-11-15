// NOTE: For this section, I'm only going to do the word-checking part. 
// I'm not going to go into the second part that involves manipulating graphics, etc.
import java.util.Scanner;
import java.lang.*;

public class Hangman{
	public static void main(String[] args) {

		System.out.println("Welcome to Hangman!");
		
		HangmanLexicon lexicon = new HangmanLexicon();
		Scanner sc = new Scanner(System.in);

		int numGuesses = 8;
		int numCorrect = 0;
		boolean gameComplete = false;
		String answer = lexicon.getRandomWord();

		char[] correctChars = new char[answer.length()];
		for (int i = 0; i < correctChars.length; i++){
			correctChars[i] = '-';
		}

		while (!gameComplete){

			// Print out game "UI"
			System.out.println("The word now looks like this: " + new String(correctChars));
			if (numGuesses == 1){
				System.out.println("You have only one guess left.");
			}
			else{
				System.out.println("You have " + numGuesses + " guesses left.");
			}
			System.out.print("Your guess: ");

			// Take in user's character guess.
			char guess = Character.toUpperCase(sc.next().charAt(0));

			if (answer.indexOf(guess) > -1){
				// Correct guess
				System.out.println("That letter is in the word!");

				// scan through the answer, changing the letters in correctChars from '-' to the letter.
				for (int i = 0; i < answer.length(); i++){
					if ((answer.charAt(i) == guess) && (correctChars[i] != guess)){
						correctChars[i] = guess;
						numCorrect++;

						// Win condition - entire word guessed.
						if (numCorrect == answer.length()){
							System.out.println("You guessed the word: " + answer);
							System.out.println("You win!");
							gameComplete = true;
						}
					}
					else if (guess == correctChars[i]){
						System.out.println("You already guessed " + guess + "!");
					}
				}

			}
			else{
				// Incorrect guess
				numGuesses--;
				System.out.println("There are no " + guess + "'s in the word.");

				// Lose condition - no guesses remaining.
				if (numGuesses == 0){
					System.out.println("The word was " + answer + ".");
					System.out.println("GAME OVER");
					gameComplete = true;
				}

			}



		}


	}
}