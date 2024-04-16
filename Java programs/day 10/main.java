package wordle;
import java.util.Scanner;
public class main {
	public static void main (String[] args)
	{
		Wordle word = new Wordle();
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to wordle");
		System.out.println();
		System.out.println("type x for wrong letter");
		System.out.println("type y for correct letter in incorrect position");
		System.out.println("type g for correct letter in correct position");
		System.out.println("Think of a word in your mind");
		String guessedWord = word.guess();
		System.out.println("The word is " + guessedWord);
		for(int num=0; num<6; num++)
		{
			String result = sc.next();
			
			if(word.isCorrect(result)) {
				System.out.println("The correct word is: "+ guessedWord);
				break;
			}
			
			else if(word.isWrong(result))
			{
				guessedWord = word.guess();
				System.out.println("The word is " + guessedWord);
			}
			else 
			{
				String sameLetters = word.checkSameLetters(result, guessedWord);
				guessedWord = word.getWord(sameLetters, guessedWord);
				System.out.println("My guess is: "+guessedWord);
			}
		}
		System.out.println("Game over");
		sc.close();
	}
}
