package trumpCards;

import java.util.Scanner;
import java.util.Random;
public class TrumpCards {
	public static Card[] cards = new Card[7];
	
	public static void initializeCards()
	{
		cards[0]= new Card("abc",12,4,300,78,4,6,9,21.1);
		cards[1]= new Card("def",30,19,678,130,8,19,6,42.2);
		cards[2]= new Card("ghi",55,28,1767,100,10,15,5,76.3);
		cards[3]= new Card("jkl",46,21,973,92,12,17,8,40.8);
		cards[4]= new Card("mno",23,15,673,61,3,12,10,29.3);
		cards[5]= new Card("pqr",19,9,503,59,1,3,11,18.7);
		cards[6]= new Card("stu",39,16,1446,82,8,12,4,61.8);
	}
	
	public static Card generateCard()
	{
		Random rand = new Random();
		return cards[rand.nextInt(0,6)];
	}
	public static void display(Card card)
	{
		System.out.println("Name: "+card.name);
		System.out.println("Matches: "+card.matches);
		System.out.println("Not Outs: "+card.not_outs);
		System.out.println("Runs: "+card.runs);
		System.out.println("High Score: "+card.high_score);
		System.out.println("Hundreds: "+card.hundreds);
		System.out.println("Fifties: "+card.fifties);
		System.out.println("ACC Ranking: "+card.acc_ranking);
		System.out.println("Average: "+card.average);
		System.out.println();
	}	
}
