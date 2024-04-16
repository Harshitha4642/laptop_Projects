package Cards;
import java.util.Random;
public class deck {
	int size;
	static String[] suit= {"spades", "clubs", "hearts","diamonds"};
	static String[] rank= {"a","2","3","4","5","6","7","8","9","10","j","q","k"};
	
	public static String[] printAllCards()
	{
		String[] card= new String[52];
		int k=0;
		for(int i=0;i<suit.length;i++) {
			for(int j=0;j<rank.length;j++) {
				card[k]= suit[i] +"  "+ rank[j];
				k++;
			}
		}
		return(card);
	}
	
	public static String randomCard()
	{
		Random rand=new Random();
		int rand_suit= rand.nextInt(0,4);
		int rand_rank= rand.nextInt(0,13);
		
		return(suit[rand_suit]+" "+rand_rank);
		
	}
	public static String drawTop()
	{
		return(suit[0]+" "+rank[0]);
	}
	public static String drawBottom()
	{
		return(suit[suit.length-1]+" "+rank[rank.length-1]);
	}
	public static String[] cardsOfRank(String rankOfCard)
	{
		String[] card1= new String[4];
		for(int i=0;i<suit.length;i++)
			card1[i]= suit[i]+"  "+rankOfCard;
		return(card1);
	}
	public static String[] cardsOfSuit(int suitOfCard)
	{
		String[] card1= new String[13];
		for(int i=0;i<rank.length;i++)
			card1[i]= rank[i]+" "+suit[suitOfCard];
		return(card1);
	}
}
