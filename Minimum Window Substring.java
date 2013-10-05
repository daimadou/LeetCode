public class Solution {
    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int []count = new int[256];
        int []track = new int[256];
        for(char c:T.toCharArray())
        {
            count[c]++; 
        }
        
        int minLen = Integer.MAX_VALUE;
        int size = 0;
        int start = 0;
        String substr = null;
        String minSubStr = null;
        for(int i = 0; i < S.length(); i++)
        {
            char key = S.charAt(i);
            track[key]++;
            if(track[key] <= count[key]&&count[key] > 0)
            {
                size++;
            }
            
            if(size==T.length())
            {
                int end = i;
                int newStart = start;
                for(int j = start; j <= end; j++)
                {
                    newStart = j;
                    int index = S.charAt(j);
                    if(track[index]==count[index])
                    {
                        substr = S.substring(j, end+1);
                        if(substr.length()<minLen)
                        {
                            minSubStr = substr;
                            minLen = minSubStr.length();
                        }
                        break;
                    }
                    if(track[index]>count[index]&&count[index]>0)
                    {
                        track[index]--;
                    }
                }
                start = newStart;
            }
        }
        
        return minLen==Integer.MAX_VALUE? "":minSubStr;
        
    }
}