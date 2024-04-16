package textProcessor;

import java.util.List;

public class Excecute {
	public String processText(List<String> parsedText) throws CannotDoUndoException
	{
		int i=0;
		Stack<String> stack = new Stack<String>();
		Stack<String> backup = new Stack<String>();
		List<String> contents = parsedText;
		int size=contents.size();
		while(true)
		{
			String temp = contents.get(i);
			if(!temp.equals(Parser.BACK) && !temp.equals(Parser.UNDO))
			{
				stack.push(temp);
			}
			else
			{
				if(temp.equals(Parser.BACK))
				{
					backup.push(stack.pop());
				}
				else
				{
					if(contents.get(i-1).equals(Parser.BACK))
					{
						stack.push(backup.pop());
						if(backup.getSize()==0)
						{
							throw new CannotDoUndoException("Cannot do undo because all operations are done");
						}
					}
					else
					{
						stack.pop();					
					}
				}
			}
			i++;
			if(i==size)
				break;
		}
		
		return(stack.toString());
	}

}
