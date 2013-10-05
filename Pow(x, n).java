public class Solution {
    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n == 0)
        {
            return 1.0;
        }
        
        double val = pow(x, n/2);
        double ret = val*val; 
        if(n%2 == 0)
        {
            return ret;
        }
        else if(n > 0)
        {
            return x*ret;
        }
        else
        {
            return ret/x;
        }
    }
}
