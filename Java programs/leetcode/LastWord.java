public class LastWord{
    public static int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        for(String sv: words)
        System.out.println(sv);
        return words[words.length-1].length();
    }

    public static void main(String[] args)
    {
        System.out.println(lengthOfLastWord("Hello world"));
    }
}