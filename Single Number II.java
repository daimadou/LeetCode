public class Solution {
    public int singleNumber(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int one = 0;
        int two = 0; 
        int noneThree = 0;
        for(int a:A)
        {
            two |= (one & a);
            one = one ^ a;
            noneThree = ~(one & two);
            one &= noneThree;
            two &= noneThree; 
        }
        return one;
    }
}