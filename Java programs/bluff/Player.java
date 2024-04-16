package bluff;

import java.util.List;

public class Player {
	public String name;
	public List<Card> cardsInHand;
	
	public Player(String name, List<Card> cards)
	{
		this.name=name;
		this.cardsInHand = cards;
	}
}
