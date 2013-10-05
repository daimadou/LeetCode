public class Solution {
    public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int sign = x >= 0? 1:-1;    
        int num = x;
        int ret = 0;
        x = Math.abs(x);
        while(x>0)
        {
            ret = ret*10 + x%10;
            x = x/10;
        }
        return num==ret? true:false; 
    }
}