public class Solution {
    public int candy(int[] ratings) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(ratings.length == 0)
        {
            return 0;
        }
        
        int[] leftCount = new int[ratings.length];
        int preVal = ratings[0];
        for(int i = 1; i < ratings.length; i++)
        {
            if(ratings[i]>preVal)
            {
                leftCount[i] = leftCount[i-1] + 1;
            }
            else
            {
                leftCount[i] = 0;
            }
            preVal = ratings[i];
        }
        
        int rightCount = 0;
        int postVal = ratings[ratings.length - 1];
        int sum = 0;
        for(int i = ratings.length - 1; i > -1; i-- )
        {
            if(ratings[i]>postVal)
            {
                rightCount = rightCount + 1;
            }
            else
            {
                rightCount = 0;
            }
            int num = Math.max(rightCount, leftCount[i]) + 1;
            sum += num;
            postVal = ratings[i];
        }
        
        return sum;
    }
}