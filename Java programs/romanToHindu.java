
import java.util.*;
import java.util.Map.Entry;
public class romanToHindu {
	public static long convert (String roman)
	{
		Map<String, Integer> symbols = new HashMap<>();
		symbols.put("I", 1);
		symbols.put("V", 5);
		symbols.put("X", 10);
		symbols.put("L", 50);
		symbols.put("C", 100);
		symbols.put("D", 500);
		symbols.put("M", 1000);
		
		int k=0;
		int[] stack= new int[11];
		char[] symbol_char=new char[15];
		symbol_char= roman.toCharArray();
		for(char i: symbol_char)
		{
			String sym=Character.toString(i);
			stack[k++]= symbols.get(sym);
		}
		
		int sum=0;
		
		for(int i=0;i<stack.length;i++)
		{
			if(i+1<stack.length) {
			    
				if(stack[i]>=stack[i+1]){
					sum=sum+stack[i];
				}
					
				else {
					sum=sum+stack[i+1]-stack[i];
					i++;
				}
			}
			else {
				sum=sum+stack[i];
			}
		}
		return(sum);
	}
	public static void main(String[] args)
	{
		
		System.out.println(convert("III"));
		System.out.println(convert("XXVII"));
		System.out.println(convert("LVIII"));
		System.out.println(convert("CXXIII"));
		System.out.println(convert("DCXLI"));
		System.out.println(convert("CCCXLIII"));
		System.out.println(convert("MMMDCCXXIV"));
		System.out.println(convert("MMMMMCDLXIX"));
	}

}
