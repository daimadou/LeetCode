public class Solution {
    public int divide(int dividend, int divisor) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = 0; 
        int ret = 0; 
        boolean sign = (dividend>=0 && divisor>=0)||(dividend<0 && divisor<0);
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        while(a >= b<<len)
        {
            len++;
        }
        
        for(int i = len - 1; i > -1; i--)
        {
            if(a >= b<<i)
            {
                ret += 1<<i;
                a -= b<<i; 
            }
        }
        
        return sign ? (ret) : (-ret);
    }
}