public class Solution {
    public String intToRoman(int num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for(int i = 0; num > 0 && i < nums.length; i++)
        {
            int times = num/nums[i];
            num -= times*nums[i]; 
            while(times > 0)
            {
                sb.append(symbols[i]);
                times--;
            }
        }
        return sb.toString();
    }
}