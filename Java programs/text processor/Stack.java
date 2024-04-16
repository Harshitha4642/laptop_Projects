package textProcessor;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
	private List<T> stack = new ArrayList<T>();
	private int top=-1;
	
	public void push(T element)
	{
		stack.add(element);
		top++;
	}
	
	public T pop()
	{
		return stack.remove(top--);
	}
	
	public T getTop()
	{ 
		return stack.get(top);
	}
	
	public int getSize()
	{
		return(top+1);
	}
	
	@Override
	public String toString()
	{
		String s = "";
		for(T i: stack)
		{
			s = s+i;
		}
		return s;
	}
}
