public class Solution {
    public void nextPermutation(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int start = -1;
        for(int i = num.length - 1; i > 0; i--)
        {
            if(num[i] > num[i-1])
            {
                start = i - 1;
                break;
            }
        }
        
        if(start != -1)
        {
            int val = num[start];
            int index = -1;
            for(int i = start + 1; i < num.length; i++)
            {
                if(num[i] > val)
                {
                    index = i;
                }
                else
                {
                    break;
                }
                
            }
            
            num[start] = num[index];
            num[index] = val; 
        }
        Arrays.sort(num, start+1, num.length);
    }
}