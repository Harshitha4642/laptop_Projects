import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams{
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<String, List<String>>();
        for(String s: strs)
        {
            char[] charr = s.toCharArray();
            Arrays.sort(charr);
           String sorted =  String.valueOf(charr);
           
           if(anagrams.containsKey(sorted))
           {
            anagrams.get(sorted).add(s);
           }
           else
           {
                List<String> l = new ArrayList<String>();
                l.add(s);
                anagrams.put(sorted, l);
           }
        }
        List<List<String>> res = new ArrayList<List<String>>();
        anagrams.forEach((key, value) ->{
            res.add(value);
        });

            return res;
        }

        public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strs);

        for (List<String> group : result) {
            System.out.println(group);
        }
    }
    }
