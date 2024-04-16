package trumpCards;

import java.util.Scanner;

public class Main {
	public static void main(String []args){
		Scanner sc  = new Scanner(System.in);
		System.out.println("Welcome to Trump cards");
		TrumpCards game = new TrumpCards();
		game.initializeCards();
		Card user_card = game.generateCard();
		Card computer_card = game.generateCard();
		System.out.println("Details of your card");
		game.display(user_card);
		System.out.println("The player of my card is "+computer_card.name);
		System.out.println("Enter the category name: ");
		Category c = new Category();
		int category_index = sc.nextInt();		
	}
}
