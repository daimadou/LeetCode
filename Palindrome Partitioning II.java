public class Solution {
    public int minCut(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = s.length();
        
        boolean [][]palindrome = new boolean[len][len];
        for(int i = len - 1; i > -1; i--)
        {
            for(int j = i; j < len; j++)
            {
                palindrome[i][j] = (((j-i<2)||palindrome[i+1][j-1]) && (s.charAt(i) == s.charAt(j)))? true: false;
            }
        }
        
        int []mincut = new int[len+1];
        mincut[len] = -1; 
        for(int i = len-1 ; i > -1; i-- )
        {
            mincut[i] = len - i - 1;
            for(int j = i; j < len; j++)
            {
                if(palindrome[i][j])
                {
                    mincut[i] =  Math.min(mincut[i], mincut[j+1]+1);
                }
            }
        }
        
        return mincut[0];
    }
    
    
}