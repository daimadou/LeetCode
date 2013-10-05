public class Solution {
    public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String regexp = "[^a-zA-Z0-9]";
        String str1 = s.replaceAll(regexp, "");
        String str2 = new StringBuffer(str1).reverse().toString();
        if(str1.equalsIgnoreCase(str2))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}