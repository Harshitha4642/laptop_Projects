package method;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {
    public static boolean isValidRegex(String expression)
    {
        Pattern pattern = Pattern.compile("[0-9][0-9][0-9].[0-9][0-9][0-9].[0-9][0-9][0-9].[0-9][0-9][0-9]");
        Matcher matcher = pattern.matcher(expression);
        boolean match_found = matcher.find();
        return match_found?true:false;
    }
    public static void main(String args[])
    {
        System.out.println(isValidRegex("233.120.123.1128"));
    }
}