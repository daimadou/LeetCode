public class Solution {
    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        while(i<j)
        {
            int val = Math.min(height[i], height[j]) * (j-i);
            max = Math.max(val, max);
            if(height[i]==height[j])
            {
                i++;
                j--;
            }
            else if(height[i] > height[j])
            {
                j--;
            }
            else
            {
                i++;
            }
        }
        return max;
    }
}