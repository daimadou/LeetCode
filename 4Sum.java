public class Solution {
    ArrayList<ArrayList<Integer>> ret;
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ret = new ArrayList<ArrayList<Integer>>();
        if(num.length < 4)
        {
            return ret;
        }
        
        Arrays.sort(num);
        int preVal = num[0] - 1;
        for(int i = 0; i < num.length - 3; i++)
        {
            if(num[i] != preVal)
            {
                threeSum(num, i + 1, target - num[i], num[i]);
            }
            preVal = num[i];
        }
        return ret;
    }
    
    private void threeSum(int[] num, int index, int target, int baseNum)
    {
        int preVal = num[index] - 1;
        for(int i = index; i < num.length - 2; i++)
        {
            if(num[i] != preVal)
            {
                twoSum(num, i + 1, target - num[i], baseNum, num[i]);
            }
            preVal = num[i];
        }
    }
    
    private void twoSum(int[] num, int index, int target, int baseNum1, int baseNum2)
    {
        int i = index;
        int preVal = num[i] - 1;
        int j = num.length - 1;
        int postVal = num[j] + 1;
        while(i<j)
        {
            int sum = num[i] + num[j];
            if(num[i] != preVal && num[j] != postVal && sum == target)
            {
                ArrayList<Integer> nums = new ArrayList<Integer>();
                nums.add(baseNum1);
                nums.add(baseNum2);
                nums.add(num[i]);
                nums.add(num[j]);
                ret.add(nums);
                preVal = num[i];
                postVal = num[j];
            }
            
            if(num[i] == preVal || sum < target)
            {
                preVal = num[i++];
            }
            
            if(num[j] == postVal|| sum > target)
            {
                postVal = num[j--];
            }
        }
    }
}