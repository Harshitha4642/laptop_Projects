package websites;

import java.util.Optional;
import java.util.Scanner;

public class Deck {
	Stack<Card> deck = new Stack<Card>();
	
	public Deck(){
		for(int i=0; i<Card.suits.length; i++)
		{
			for(int j=0; j<Card.ranks.length; j++)
			{
				deck.push(new Card(Card.suits[i], Card.ranks[j]));
			}
		}
		deck.shuffleStack();
	}
	
	public boolean empty()
	{
		return deck.isEmpty();
	}
	
	public Card removeCardFromDeck()
	{
		return deck.pop();
	}
	
	public static void main(String [] args)
	{
		Deck d=new Deck();	
		Optional<Card> inpile = java.util.Optional.empty();
		Optional<Card> outpile = java.util.Optional.empty();

		int count = 0;
		Scanner sc = new Scanner(System.in);
		
		while(!d.empty())
		{
			if(count%2==0)
			{
				inpile=Optional.ofNullable(d.removeCardFromDeck());
			}
			else 
			{
				outpile=Optional.ofNullable(d.removeCardFromDeck());
			}
			count++;
			if(!inpile.isEmpty()&&!outpile.isEmpty()) {
				System.out.println(inpile.get().toString().equals(outpile.get().toString()));
			}
			if(!outpile.isEmpty()) {
				System.out.println("outpile: "+outpile.get().toString());
			}
		}
		
	}
}
