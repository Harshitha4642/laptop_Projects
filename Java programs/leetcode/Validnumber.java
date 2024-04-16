public class Validnumber{
    public static boolean isNumber(String s) {
        char[] letters = s.toCharArray();

        if((s.charAt(0)=='+' && s.charAt(1)=='-') || 
        (s.charAt(0)=='-' && s.charAt(1)=='+') ||
        (s.charAt(0)=='+' && s.charAt(1)=='+') ||
        (s.charAt(0)=='-' && s.charAt(1)=='-'))
        {
            return false;
        }

        if(s.contains("-") || s.contains("+"))
        {
            if(s.charAt(0)!='-' && s.charAt(0)!='+')
            {
                int index = s.contains("-") ? s.indexOf('-') : s.indexOf('+');
                if(!(s.charAt(index-1) == 'E' || s.charAt(index-1) == 'e' ))
                    return false;   
            }
        }

        for(char c: letters)
        {
            if(Character.isLetter(c) && c!='e')
                return false;
        }

        if(s.length()==1)
        {
            if(s.equals("+") || s.equals("-") || s.equals(".")){
                return false;
            }
        }
        if(s.startsWith("e") || s.endsWith(("e")))
        {
            return false;
        }

        if(s.contains("e") || s.contains("E"))
        {
            int index = 0;
            if(s.contains("e"))
                index = s.indexOf("e");
            else if(s.contains("E"))
                index = s.indexOf("E");

                
            if( !(Character.isDigit(s.charAt(index-1)) && (Character.isDigit(s.charAt(index+1)) || s.charAt(index+1) == '-' || s.charAt(index+1) == '+' )))
            {
                return false;
            }
        }
        int decimals =0;
        for(char c: letters)
        {
            if(c == '.')
            {
                decimals++;
            }
        }
        if(decimals>1)
            return false;
        return true;
    }

    public static void main(String args[])
    {
        System.out.println(isNumber("-1.0"));
    }
}