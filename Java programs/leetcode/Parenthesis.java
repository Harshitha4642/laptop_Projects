import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Parenthesis{
    public static boolean isValid(String s) {
        Map<Character, Character> brackets = new HashMap<Character,Character>();
        brackets.put('{','}');
        brackets.put('[',']');
        brackets.put('(',')');

        Stack<Character> stack = new Stack<>();
        char[] input = s.toCharArray();

        for(char c: input)
        {
            if(brackets.containsKey(c))
            {
                stack.add(c);
            }
            else
            {
                if(brackets.containsValue(c))
                {
                    if(!stack.isEmpty() && stack.peek()==getKey(c, brackets)){
                        stack.pop();
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        if(stack.empty())
            return true;
        else
            return false;
    }

    public static char getKey(char c, Map<Character, Character> brackets)
    {
        for (Map.Entry<Character, Character> entry : brackets.entrySet()) {
        if (entry.getValue() == c) {
            return entry.getKey();
        }
    }
    return 'v';
    }

    public static void main(String[] args)
    {
        System.out.println(isValid("]"));
    }
}