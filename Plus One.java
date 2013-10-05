public class Solution {
    public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int carryOut = 1;
        int []ret = new int[digits.length+1];
        for(int i = digits.length-1; i > -1; i--)
        {
            int val = digits[i] + carryOut;
            digits[i] = val%10;
            ret[i+1] = digits[i];
            carryOut = val/10;
        }
        if(carryOut==1)
        {
            ret[0] = carryOut;
            return ret;
        }
        else
        {
            return digits;
        }
    }
}