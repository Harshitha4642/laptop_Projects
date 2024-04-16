package bluff;

import java.util.ArrayList;
import java.util.List;

import bluff.Card.Rank;

public class GameMethods {
	public Deck deck = new Deck();
	public Player[] players = new Player[3];
	List<Card> c1= new ArrayList<Card>();
	List<Card> c2= new ArrayList<Card>();
	List<Card> c3= new ArrayList<Card>();
	
	//List<Card> permanentlyRemovedCards = new ArrayList<Card>();
	List<List<Card>> temporarilyRemovedCards = new ArrayList<List<Card>>();
	
	String names1,names2,names3;
	
	
	public void initializeGame()
	{
		deck.initializeDeck();
		List<Card> l = new ArrayList<Card>();
		temporarilyRemovedCards.add(l);
		List<Card> l1 = new ArrayList<Card>();
		temporarilyRemovedCards.add(l1);
		List<Card> l2 = new ArrayList<Card>();
		temporarilyRemovedCards.add(l2);
		
	}
	
	public void setNames(String name1, String name2, String name3)
	{
		names1=name1;
		names2=name2;
		names3=name3;
		
	}
	
	public void distributeCards()
	{
		
		while(deck.getLength()>0)
		{
			if(deck.getLength()>0)
				c1.add(deck.removeCard());
			if(deck.getLength()>0)
				c2.add(deck.removeCard());
			if(deck.getLength()>0)
				c3.add(deck.removeCard());
			
		}
		
		players[0] = new Player(names1,c1);
		players[1] = new Player(names2,c2);
		players[2] = new Player(names3,c3);
		
	}
	
	public String getCards(int id) {
		String cards = "";
		int i=0;
		for(Card c: players[id].cardsInHand)
		{
			cards=cards+i+" "+c.toString()+"\n";
			i++;
		}
		return cards;
	}
	
	public int checkSpadeAce()
	{
		Card c = new Card(Card.suits[0],Rank.SPADE);
		int i=0;
		for(Player p: players)
		{
			for(Card card: p.cardsInHand)
			{
				if(card.toString().equals(c.toString()))
					return i;
			}
			i++;
		}
		return -1;
	}
	
	public void removeCards(List<Card> cards, int turn)
	{
		for(Card c: cards) {
			temporarilyRemovedCards.get(turn).add(c);
			players[turn].cardsInHand.remove(c);
		}
	}
	
	public boolean checkBluff(String suitChoosen, int prevturn)
	{
		int len=0;
		for(int i=0;i<temporarilyRemovedCards.get(prevturn).size();i++) {
			Card c =  temporarilyRemovedCards.get(prevturn).get(i);
			if(c.suit.equals(suitChoosen)) {
				len++;
			}
			else
				return true;
		}
		if(len==temporarilyRemovedCards.get(prevturn).size())
			return false;
		return true;
	}
	
	public void modifyCards(int turn)
	{
		System.out.println(temporarilyRemovedCards.size());
		for(int t=0; t<3; t++) {
			players[turn].cardsInHand.addAll(temporarilyRemovedCards.get(t));
		}
		temporarilyRemovedCards.clear();
		List<Card> l = new ArrayList<Card>();
		temporarilyRemovedCards.add(l);
		List<Card> l1 = new ArrayList<Card>();
		temporarilyRemovedCards.add(l1);
		List<Card> l2 = new ArrayList<Card>();
		temporarilyRemovedCards.add(l2);
		
	}
}
