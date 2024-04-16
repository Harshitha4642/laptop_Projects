import java.util.List;
import java.util.ArrayList;

class Solution {
    public static int lengthOfLongestSubstring(String s) {
        char [] arr = s.toCharArray();
        int j=0;
        List<Character> lis = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();
        for(int i=0; i<arr.length; i++)
        {
            for(j=i; j<arr.length; j++)
            {
                if(!lis.contains(arr[j]))
                {
                    lis.add(arr[j]);
                }
                else
                    break;
            }
            sizes.add(lis.size());
            lis.clear();
        }

        int maxi=0;
        for(int i: sizes)
        {
            if(i>maxi)
            maxi = i;
        }
       
        return maxi;
    }
    public static void main(String[] args)
    {
        System.out.println(lengthOfLongestSubstring("harshitha"));
    }
}