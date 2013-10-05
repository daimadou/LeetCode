public class Solution {
    public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String ret = "1";
        for(int i = 1; i < n; i++)
        {
            ret = generateStr(ret);
        }
        return ret;
        
    }
    
    String generateStr(String s)
    {
        char[] chars = s.toCharArray();
        int preVal = chars[0] - '0';
        StringBuffer sb = new StringBuffer();
        int count = 1;
        for(int i = 1; i <= chars.length; i++)
        {
            int val = i < chars.length? chars[i]-'0':(chars[chars.length - 1] - '0') + 1;
            if(val != preVal)
            {
                sb.append(count);
                sb.append(preVal);
                count = 1;
            }
            else
            {
                count++;
            }
            preVal = val;
        }
        return sb.toString();
    }
}