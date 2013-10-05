import java.util.regex.*;
public class FindLastWordLength {
    public int lengthOfLastWord(String s) {
        // Start typing your Java FindLastWordLength below
        // DO NOT write main() function
        String regexp = "\\s*([a-zA-Z]*)\\s*$";

        Pattern p = Pattern.compile(regexp);
       	Matcher m = p.matcher(s);
       	if(m.find())
        	System.out.println(m.group());
        return 0;
    }

    public static void main(String[] Args)
    {
     	FindLastWordLength findLastWordLength = new FindLastWordLength();
     	findLastWordLength.lengthOfLastWord("Hello world");
    	String test = " ";
    	String []words = test.split(" ");
    	if(words.length == 0)
    		return;
    	int lastIndex = words.length -1 ;
    	System.out.println(words[lastIndex]);

    };
}