package bluff;

public class Card {
	
	static enum Rank{
		CLUB, SPADE , HEART ,DIAMOND;
	}
	
	public static String suits[]= {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	
	public String suit;
	public Rank rank;
	
	public Card(String value, Rank rank)
	{
		this.suit = value;
		this.rank = rank;
	}
	@Override
	public String toString()
	{
		return suit+" "+rank;
	}

}
