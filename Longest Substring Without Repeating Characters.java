public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.isEmpty())
        {
            return 0;
        }
        
        int[] prePosMap = new int[255];
        Arrays.fill(prePosMap, -1);
        int maxLen = 1;
        int start = -1;
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(prePosMap[c] != -1)
            {
                for(int j = start + 1; j < prePosMap[c]; j++)
                {
                    prePosMap[s.charAt(j)] = -1;   
                }
                start = prePosMap[c];
            }
            prePosMap[c] = i;
            maxLen = Math.max(maxLen, i - start);
        }
        return maxLen;
    }
}