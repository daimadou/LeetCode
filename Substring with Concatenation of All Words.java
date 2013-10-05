public class Solution {
    private ArrayList<Integer> ret;
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ret = new ArrayList<Integer>(); 
        HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
        for(String s: L)
        {
            int val = wordCount.containsKey(s)? wordCount.get(s):0;
            wordCount.put(s, ++val);
        }
        
        int wordLen = L[0].length(); 
        boolean[] dp = new boolean[S.length()];
        for(int i = 0; i < S.length() - wordLen + 1; i++)
        {
            dp[i] = wordCount.containsKey(S.substring(i, i+wordLen));
        }
        
        for(int i = 0; i < wordLen; i++)
        {
            _findSubString(S, L, wordCount, dp, i, wordLen);   
        }
        
        return ret;
    }
    
    private void _findSubString(String S, String[] L, HashMap<String, Integer> wordCount, boolean[] dp, int start, int wordLen)
    {
        HashMap<String, Integer> wordFound = new HashMap<String, Integer>();
        int size = 0;
        int index = start;
        for(int i = start; i < S.length()-wordLen + 1; i += wordLen)
        {
            String s = S.substring(i, i+wordLen);
            if(!dp[i])
            {
                wordFound.clear();
                index = i+wordLen;
                size = 0;
            }
            else
            {
                int count = wordFound.containsKey(s)? wordFound.get(s):0;
                if(count < wordCount.get(s))
                {
                    size++;
                } 
                wordFound.put(s, ++count);
                
                if(size==L.length)
                {
                    ret.add(index);
                }
                
                if((i-index)/wordLen + 1 == L.length)
                {
                    String word = S.substring(index, index+wordLen);
                    int val = wordFound.get(word);
                    if(val <= wordCount.get(word))
                    {
                        size--;
                    }
                    wordFound.put(word, --val);
                    index += wordLen; 
                }
            }
        }
    }
}