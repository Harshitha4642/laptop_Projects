import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DialPad{
    public static String longestCommonPrefix(String[] strs) {
        int mini = Integer.MAX_VALUE;
        String miniStr = "";
        String res = "";
        for(String s: strs)
        {
            if(mini>s.length()){
                mini = s.length();
                miniStr = s; 
            }
        }

        for(int i=0; i<mini; i++)
        {
            char c = miniStr.charAt(i);
            for(String st: strs)
            {
                if(!(st.charAt(i) == c))
                {
                    return res;
                }
            }
            res = res+c;
        }
        return res;
        
    }

    public static void main(String[] args)
    {
        String[] st = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(st));
    }
}

