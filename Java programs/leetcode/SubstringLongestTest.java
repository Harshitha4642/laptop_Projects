public class SubstringLongestTest{
    public static String findLongest(String [] words)
    {
        int min = Integer.MAX_VALUE;
        String smallword = "";
        for(String w: words)
        {
            if(w.length()< min)
            {
                min = w.length();
                smallword = w;
            }
        }
        String result = "";
        char c = 'x';
        for(int i=0; i<smallword.length(); i++)
        {
            for(int j=0; j<words.length; j++)
            {
                if(words[j].contains(Character.toString(smallword.charAt(i))))
                {
                    c = smallword.charAt(i);
                }
                else{
                    return result;
                }
            }
            result = result+c;
        }
        return result;
    }
    public static void main(String args[])
    {
        String arr[] = {"flower", "flow", "flight"};
        System.out.println(findLongest(arr));
        String arr1[] = {"apple", "app", "application"};
        System.out.println(findLongest(arr1));
        String arr2[] = {"dog", "racecar", "car"};
        System.out.println(findLongest(arr2));
    }
}