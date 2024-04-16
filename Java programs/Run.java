package instagram;

import java.sql.SQLException;
import java.util.Scanner;

public class Run {
	public static void main(String args[]) throws SQLException
	{
		Scanner sc = new Scanner(System.in);
		Actions action = new Actions();
		
		System.out.println("Welcome to addiction-free console instagram\n");
		System.out.println("Enter the activity you want to do :)");
		System.out.println("1. Like a post");
		System.out.println("2. Comment on a post");
		System.out.println("3. Check the reach of a post");
		
		int choice = sc.nextInt();
		
		switch(choice)
		{
			case 1: action.likePost();
				return;
				
			case 2: action.commentOnPost();
				return;
				
			case 3: action.showReach();
				return;
			
			default:
				System.out.println("Lets be serious bro!!");
				return;
		}
		
		
	}

}
