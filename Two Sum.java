public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        Integer[] index = new Integer[numbers.length];
        final int[] num = numbers;
        for(int i = 0; i < index.length; i++)
        {
            index[i] = i; 
        }
        Arrays.sort(index, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b)
            {
                if(num[a] > num[b])
                {
                    return 1;
                }
                else if(num[a] == num[b]) 
                {
                    return 0;
                }
                else
                {
                    return -1;
                }
            }
        });
        
        int i = 0;
        int j = numbers.length - 1;
        while(i < j)
        {
            int sum = numbers[index[i]] + numbers[index[j]];
            if(sum == target)
            {
                break;
            }
            else if(sum < target)
            {
                i++;
            }
            else
            {
                j--;
            }
        }
        int[] ret = new int[2];
        ret[0] = (index[i] < index[j] ? index[i]: index[j]) + 1;
        ret[1] = (index[i] < index[j] ? index[j]: index[i]) + 1;
        return ret;
    }
}