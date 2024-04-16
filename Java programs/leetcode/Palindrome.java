import java.util.List;
import java.util.ArrayList;

class Plaindrome {
    public static String longestPalindrome(String s) {
        if(s.length()==1)
        {
            return s;
        }
        if(s.length()==0)
        {
            return "";
        }
        char [] arr = s.toCharArray();
        List<String> palins = new ArrayList<String>();
        List<Integer> sizes = new ArrayList<Integer>();
        for(int i=0; i<arr.length; i++)
        {
            for(int j=arr.length-1; j>i; j--)
            {
                if(arr[i] == arr[j])
                {
                    if(isPalindrome(s.substring(i, j+1)))
                    {
                        String str = s.substring(i, j+1);
                        palins.add(str);
                        sizes.add(str.length());
                    }
                }
            }
        }

        if(palins.isEmpty())
            return "";
        int maxi=palins.get(0).length();
        String res = palins.get(0);
        for(String st: palins)
        {
            if(maxi<st.length()){
                maxi=st.length();
                res = st;
            }
        }
        return res;
    }

    public static boolean isPalindrome(String s)
    {
        int count=0;
        for(int i=0; i<s.length()/2; i++)
        {
            if(s.charAt(i) == s.charAt(s.length()-1-i))
            {
                count++;
            }
            else
                return false;
        }
        if(count==s.length()/2)
            return true;
        return false;
    }
    public static void main(String[] args)
    {
        System.out.println(longestPalindrome("cu"));
    }
}