public class Solution {
    public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function

        HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        
        int maxCount = 1;
        for(int i: num)
        {
            if(hashmap.containsKey(i))
            {
                continue;
            }
            
            hashmap.put(i, 1);
            
            if(hashmap.containsKey(i+1))
            {
                maxCount = Math.max(maxCount, getLen(hashmap, i + 1, i));
            }
            
            if(hashmap.containsKey(i-1))
            {
                maxCount = Math.max(maxCount, getLen(hashmap, i, i - 1));
            }

        }
        
        return maxCount;
    }
    
    private int getLen(HashMap<Integer, Integer> hashmap, int up, int low)
    {
        int upper = up + hashmap.get(up) - 1;
        int lower = low - hashmap.get(low) + 1;
        int len = upper - lower + 1;
        hashmap.put(upper, len);
        hashmap.put(lower, len);
        return len;
    }
    
}