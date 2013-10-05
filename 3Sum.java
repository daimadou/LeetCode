public class Solution {
    ArrayList<ArrayList<Integer>> ret;
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ret = new ArrayList<ArrayList<Integer>>();
        if(num.length < 3)
        {
            return ret;
        }
        
        Arrays.sort(num);
        int preVal = num[0] - 1;
        for(int i = 0; i < num.length - 2; i++)
        {
            if(num[i] != preVal)
            {
                twoSum(num, i + 1, -num[i]);
            }
            preVal = num[i];
        }
        return ret;
    }
    
    private void twoSum(int[] num, int index, int target)
    {
        int i = index;
        int preVal = num[i] - 1;
        int j = num.length - 1;
        int postVal = num[j] + 1; 
        while(i<j)
        {
            int sum = num[i] + num[j];
            if(preVal != num[i] && postVal != num[j] && sum == target)
            {
                ArrayList<Integer> nums = new ArrayList<Integer>();
                nums.add(-target);
                nums.add(num[i]);
                nums.add(num[j]);
                ret.add(nums);
                preVal = num[i];
                postVal = num[j];
                    
            }
            
            if(preVal == num[i] || sum < target)
            {
                preVal = num[i];
                i++;
            }
            
            if(postVal == num[j] || sum > target)
            {
                postVal = num[j];
                j--;
            }
            
        }
    }
}