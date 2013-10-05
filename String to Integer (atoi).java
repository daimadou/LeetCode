public class Solution {
    public int atoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(str.isEmpty())
        {
            return 0;
        }
        int num = 0;
        int start = 0;
        int sign = 1;
        while(start < str.length())
        {
            if(str.charAt(start)!=' ')
            {
                break;
            }
            start++;
        }
        if(start < str.length())
        {
            int firstVal = str.charAt(start);
            if(firstVal=='+'||firstVal=='-')
            {
                if(firstVal == '-')
                {
                    sign = -1;
                }
                start++;
            }
            
            for(int i = start; i < str.length(); i++)
            {
                int val = str.charAt(i) - '0';
                if(val>=0&&val<=9)
                {
                    if((num == (Integer.MAX_VALUE / 10) && val > 7)|| (num > (Integer.MAX_VALUE / 10)))
                    {
                        return sign>0? Integer.MAX_VALUE:Integer.MIN_VALUE;
                    }
                    else
                    {
                        num = num*10 + val;
                    }
                }
                else
                {
                    break;       
                }
            }
            
        }
        return sign*num;
    }
}