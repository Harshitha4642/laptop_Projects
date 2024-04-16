package wordle;
import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Wordle {
	
	ArrayList<String> words = new ArrayList<String>();
	ArrayList<String> matchingWords = new ArrayList<String>();
	Random rand = new Random();
	private final int LENGTH = 5;
	
	public Wordle()
	{
		try {
		      File myObj = new File("/home/harshithams/eclipse-workspace/oops/src/wordle/wordsdata.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        words.add(data);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
 	
	public String guess()
	{
		int num = rand.nextInt(0,words.size());
		return(words.get(num));
	}
	
	public boolean isCorrect(String input)
	{
		return input.equals("ggggg");
	}
	
	public boolean isWrong(String input)
	{
		return input.equals("xxxxx");
	}
	
	public String checkSameLetters(String result, String guess)
	{
		char[] temp_result = result.toLowerCase().toCharArray();
		char[] temp_guess = guess.toLowerCase().toCharArray();
		String g_letters = "";
		String y_letters = "";
		for(int i = 0; i < LENGTH; i++)
			if(temp_result[i] == 'g')
				g_letters = g_letters +"[" + temp_guess[i]+"]";
			else
				g_letters = g_letters + "[a-z]";
		
		for(int i = 0; i < LENGTH; i++)
			if(temp_result[i] == 'y')
				y_letters = y_letters + temp_guess[i];
		return(g_letters+ " " + y_letters);
	}
	
	public String getWord(String pattern, String guess)
	{
		String[] arr = pattern.split(" ",2);
		for( String w : words)
		{
			if((w.matches(arr[0]) && !w.equals(guess)))
			{
				if(has(w,arr[1])) {
					matchingWords.add(w);
				}
			}
		}
		makeWords();
		System.out.println(words.size());
		return words.get(rand.nextInt(0,words.size()));
	}
	
	private void makeWords()
	{
		words.clear();
		for(String wor : matchingWords)
			words.add(wor);
		matchingWords.clear();
	}
	private boolean has(String w, String s)
	{
		char[] temp = s.toCharArray();
		int c=0;
		for(int j=0; j<temp.length; j++)
			if(w.contains(Character.toString(temp[j])))
				c++;
		return c==temp.length;
	}
}
