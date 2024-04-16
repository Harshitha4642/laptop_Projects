import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class phoneNames{
    public static List<String> letterCombinations(String digits) {
        Map<Integer, String> dialpad = new HashMap<Integer, String>();
        dialpad.put(2, "abc");
        dialpad.put(3, "def");
        dialpad.put(4,"ghi");
        dialpad.put(5,"jkl");
        dialpad.put(6, "mno");
        dialpad.put(7,"pqrs");
        dialpad.put(8,"tuv");
        dialpad.put(9,"wxyz");


        List<String> lis = new ArrayList<String>();

        if(digits.contains("0") || digits.contains("1") || digits.contains(" ") || digits.equals(""))
        {
            return lis;
        }
        String first = dialpad.get(Integer.parseInt(Character.toString(digits.charAt(0))));
        for(int i=0; i<first.length(); i++)
        {
            lis.add(Character.toString(first.charAt(i)));
        }
        for(int i=1; i<digits.length(); i++)
        {
           char c = digits.charAt(i);
           System.out.println("what i sent");
           lis.forEach((s) -> {System.out.println(s);});
            lis = addLetters(lis,dialpad.get(Integer.parseInt(Character.toString(c))));
            System.out.println("what i got");
           lis.forEach((s) -> {System.out.println(s);});
        }
        return lis;
    }

    public static List<String> addLetters(List<String> lis, String values)
    {
        List<String> res = new ArrayList<String>();
        lis.forEach((s) -> {
            for(int i=0; i<values.length(); i++)
            {
                res.add(s+ values.charAt(i));
            }
        });
        return res;
    }

    public static void main(String[] args)
    {
        List<String> result = letterCombinations("236");
        result.forEach((s) -> {System.out.println(s);});
    }
}