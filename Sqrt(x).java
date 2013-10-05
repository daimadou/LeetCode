public class Solution {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x==1)
        {
            return 1;
        }
        
        int left = 0;
        int right = x;
        int ret = 0;
        while(right - left > 1)
        {
            int mid = (left + right)/2;
            if(mid == x/mid)
            {
                break;
            }
            else if(mid > x/mid)
            {
                right = mid;
            }
            else
            {
                left = mid;
            }
        }
        
        ret = (left+right)/2;
        return ret;
    }
}