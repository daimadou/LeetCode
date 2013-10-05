public class Solution {
    public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int []factorial = new int[n+1];
        factorial[0] = 1;
        ArrayList<Integer> num = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++)
        {
            factorial[i] = i*factorial[i-1];
            num.add(i);
        }
        StringBuffer sb = new StringBuffer();
        for(int i = n - 1; i > -1; i--)
        {
            int val = 0;
            for(int j = 0; j < num.size(); j++)
            {
                val += factorial[i];
                if(val >= k)
                {
                    sb.append(num.get(j));
                    num.remove(j);
                    k = k - (val - factorial[i]);
                    break;
                }
            }
        }
        
        return sb.toString();
    }
}