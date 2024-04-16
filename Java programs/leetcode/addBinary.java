public class addBinary{
    public static String addTwoDarlings(String a, String b)
    {
        int diff = Math.abs(a.length() - b.length());
        if(a.length()>b.length())
            b = modifyString(b, diff);
        else if(a.length()<b.length())
            a = modifyString(a, diff);
        
        System.out.println(a.length() == b.length());
        System.out.println(a+"  "+b);
        char carry = '0';
        String result = "";
        for(int i=0; i<a.length(); i++)
        {
            char bitA = a.charAt(i);
            char bitB = b.charAt(i);
            
            if(bitA != bitB)
            {
                if(carry == '1'){
                    result = "0" + result;
                    carry = '1';
                }
                else{
                    result="1"+ result;
                    carry = '0';
                }
            }

            else if(bitA == '0' && bitB == '0')
            {
                if(carry == '1'){
                    result="1"+ result;
                    carry = '0';
                }
                else{
                     result = "0" + result;
                    carry = '0';
                }
            }
            else if(bitA == '1' && bitB == '1')
            {
                if(carry == '1'){
                    result="1"+ result;
                    carry = '1';
                }
                else{
                    result="0"+ result;
                    carry = '1';
                }
            }
            System.out.println(result);
        }
        return result;
    }

    public static String modifyString(String str, int diff)
    {
        String result = "";
        for(int i=0; i<diff; i++)
            result+="0";
        result+=str;
        return result;
    }

    public static void main(String args[])
    {
        System.out.println("result "+addTwoDarlings("11", "1"));
    }
}