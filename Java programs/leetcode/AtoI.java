public class AtoI{
    public static int myAtoi(String s) {
        System.out.println(s);
        s = s.replace(" ","");
        System.out.println(s);
        String numbers = "0123456789-+";
        String number = "";
        int flag = 0;
        if(!numbers.contains(Character.toString(s.charAt(0))))
        {
            System.out.println("helcn");
            return 0;
        }
        for(int i=0; i<s.length(); i++)
        {
            String ch =  Character.toString(s.charAt(i));
            if(numbers.contains(ch))
            {
                flag = 1;
                number +=s.charAt(i);
            }
           else if((Character.isLetter(s.charAt(i)) || s.charAt(i)=='.' || s.charAt(i)=='+' || s.charAt(i)=='-') && flag==1)
            {
                break;
            }
        }
        System.out.println("string: "+number);
        String mainNumber= number;
        if(number.contains("-") && !number.startsWith("-"))
        {
            String[] nums = number.split("-");
            mainNumber = nums[0];
        }
        if(Long.valueOf(mainNumber)>Integer.MAX_VALUE){
            return 0;
        }
        return Integer.valueOf(mainNumber);
    }

    public static void main(String[] args)
    {
        System.out.println(myAtoi("-91283472332"));
    }
}