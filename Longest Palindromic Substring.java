public class Solution {
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String ret = "";
        int maxLen = 0;
        for(int i = 0; i < s.length(); i++)
        {
            String str1 = longestPalindrome(s, i, i);
            if(str1.length() > maxLen)
            {
                maxLen = str1.length();
                ret = str1;
            }
            if(i+1 < s.length())
            {
                String str2 = longestPalindrome(s, i, i + 1);
                if(str2.length() > maxLen)
                {
                    maxLen = str2.length();
                    ret = str2;
                }
            }
            
        }
        return ret;
    }
    
    public String longestPalindrome(String s, int i, int j)
    {
        if(s.charAt(i) != s.charAt(j))
        {
            return s.substring(i, i + 1);
        }
        
        int start = i;
        int end = j;
        while(i > -1 && j < s.length())
        {
            if(s.charAt(i) == s.charAt(j))
            {
                start = i;
                end = j;
                i--;
                j++;
            }
            else
            {
                break;
            }
        }
        return s.substring(start, end + 1);
    }
}