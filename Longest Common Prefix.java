public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(strs.length == 0)
        {
            return "";
        }
        
        int len = strs[0].length();
        for(int i = 0; i < len; i++)
        {
            for(int j = 0; j < strs.length; j++)
            {
                if(i == strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i))
                {
                    String ret = strs[0].substring(0, i);
                    return ret;
                }
            }
        }
        return strs[0];
    }
}