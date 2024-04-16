package bluff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	List<Card> deck;
	public int length;
	private static int TOP=0;
	public void initializeDeck()
	{
		deck = new ArrayList<Card>();
		for(int i=0; i<Card.suits.length;i++)
		{
			Card c1 = new Card(Card.suits[i],Card.Rank.CLUB);
			Card c2 = new Card(Card.suits[i],Card.Rank.SPADE);
			Card c3 = new Card(Card.suits[i],Card.Rank.DIAMOND);
			Card c4 = new Card(Card.suits[i],Card.Rank.HEART);
			
			
			
			deck.add(c1);
			deck.add(c2);
			deck.add(c3);
			deck.add(c4);
		}
		Collections.shuffle(deck);
	}
	public int getLength()
	{
		return deck.size();
	}
	
	public Card removeCard()
	{
		return deck.remove(TOP);
	}
}
