package method;

import java.util.ArrayList;
import java.util.List;

public class Idly {
	public static boolean canMake(int small, int big, int goal)
	{
		int small_x, big_y=0;
		small_x = (goal/100) - 5*big_y;
		
		List<Integer> small_list = new ArrayList<Integer>();
		List<Integer> big_list = new ArrayList<Integer>();
		
		for(int i=0; i<=small; i++)
		{
			small_list.add(i);
		}
		for(int i=0; i<=big; i++)
		{
			big_list.add(i);
		}	
		for(int i=0 ; i<=big ; i++)
		{
			small_x = (goal/100) - 5*i;
			System.out.println(small_x+"  "+i);
			if(small_x <= small && small_x >=0)
				return true;
		}
		small_x = (goal/100)%5;
		//(small_x)
		return false;
	}

	public static void main(String [] args)
	{
		System.out.println(canMake(2,3,600));
		System.out.println(canMake(3,1,800));
		System.out.println(canMake(3,1,900));
		System.out.println(canMake(3,2,1000));
		System.out.println(canMake(3,2,800));
		System.out.println(canMake(2,2,800));
	}
}
