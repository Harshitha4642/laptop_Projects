package Cards;

public class testDeck {
	public static void main(String[] args) {
		deck rand=new deck();
		
		String res[]= deck.printAllCards();
		for(String i:res) {
			System.out.println(i);
		}
		System.out.println(deck.randomCard());
		System.out.println(deck.drawTop());
		System.out.println(deck.drawBottom());
		String res1[]= deck.cardsOfRank("a");
		for(String i:res1) {
			System.out.println(i);
		}
		String res2[]= deck.cardsOfSuit(0);
		for(String i:res2) {
			System.out.println(i);
		}
	}
}
