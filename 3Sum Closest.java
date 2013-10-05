public class Solution {
    public int threeSumClosest(int[] num, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(num.length < 3)
        {
            return Integer.MAX_VALUE;
        }
        Arrays.sort(num);
        int minDiff = Integer.MAX_VALUE;
        int ret = 0;
        for(int i = 0; i < num.length - 2; i ++)
        {
            int sum = num[i] + twoSumCloset(num, i + 1, target - num[i]);
            if(Math.abs(target - sum) < minDiff)
            {
                ret = sum;
                minDiff = Math.abs(target - sum);
            }
        }
        return ret;
    }
    
    private int twoSumCloset(int[] num, int index, int target)
    {
        int i = index;
        int j = num.length - 1;
        int minDiff = Integer.MAX_VALUE;
        int ret = 0;
        while(i < j)
        {
            int sum = num[i] + num[j];
            if(Math.abs(target - sum) < minDiff)
            {
                ret = sum;
                minDiff = Math.abs(target - sum);
            }
            if(sum < target)
            {
                i++;
            }
            else if(sum > target)
            {
                j--;
            }
            else
            {
                break;
            }
        }
        
        return ret;
    }
}