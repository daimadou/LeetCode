public class Solution {
    public String multiply(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = num1.length() + num2.length();
        int []num = new int[len];
        for(int i = num1.length()-1; i > -1; i--)
        {
            int val1 = num1.charAt(i) - '0';
            for(int j = num2.length()-1; j > -1; j--)
            {
                int val2 = num2.charAt(j) - '0';
                num[i+j+1] += val1*val2;
            }
        }
        
        int carryOut = 0;
        StringBuffer sb = new StringBuffer();
        int val = 0;
        for(int i = len-1; i > 0; i--)
        {
            val = (num[i] + carryOut)%10;
            carryOut = (num[i] + carryOut)/10;
            sb.insert(0, val);
        }
        
        if(carryOut == 0 && val == 0)
        {
            return "0";
        }
        else if(carryOut!=0)
        {
            sb.insert(0,carryOut);
        }
        return sb.toString();
        
    }
}