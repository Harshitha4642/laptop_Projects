package bluff;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Play {
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		String name1,name2,name3;
		int turn=0, round=1, choice, prevturn=0;
		GameMethods game = new GameMethods();
		List<Card> cards = new ArrayList<Card>();
		
		System.out.println("Enter player names");
		name1 = sc.next();
		name2 = sc.next();
		name3 = sc.next();
		
		game.initializeGame();
		game.setNames(name1, name2, name3);
		game.distributeCards();
		
		for(int i=0; i<3; i++) {
			System.out.println(game.players[i].name+" is playing");
			System.out.println(game.getCards(i));
		}		
		
		System.out.println("Note your cards");
		System.out.println("Game starts");
		
		
		final int firstturn = game.checkSpadeAce();
		System.out.println(game.players[firstturn].name+" plays first");
		System.out.println("_____________________________________________________________________");
		
		turn = firstturn;
		String suit= "A";
		
		while(round<10) {
			System.out.println(game.players[turn].name+" plays");
			System.out.println(game.getCards(turn));
			System.out.println("Enter your choice:\n1. Throw Cards\n2. Pass\n3. Say bluffed\n");
			choice = sc.nextInt();
			if(choice==1)
			{
				if(turn==firstturn && round>1) {
					System.out.println("Enter the suit you want to remove");
					suit = sc.next();
				}
				System.out.println("Enter the number of cards you want to remove from deck");
				int num = sc.nextInt();
				
				
				System.out.println("Select the index of Cards");
				for(int s=0; s<num; s++)
				{
					cards.add(game.players[turn].cardsInHand.get(sc.nextInt()));
				}
				
				game.removeCards(cards, turn);
				cards.clear();
				System.out.println(game.players[turn].name+" removed "+num+" cards of suit "+suit);
				
			}
			else if(choice==2)
			{
				System.out.println(game.players[turn].name+ " passed the game");
			}
			else if(choice==3)
			{
				System.out.println(prevturn);
				boolean bluff = game.checkBluff(suit, prevturn);
				if(bluff) {
					game.modifyCards(prevturn);
					System.out.println(game.players[prevturn].name+" bluffed the game");
				}
				else {
					game.modifyCards(turn);
					System.out.println(game.players[prevturn].name+" did not bluff the game");
				}
			}			
			
			prevturn=turn;
			turn=(turn+1)%3;
			if(turn==firstturn)
			{
				round++;
			}
			System.out.println("_____________________________________________________________________");
		
		}
	sc.close();	
	}

}
