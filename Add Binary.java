public class Solution {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(a.isEmpty()&&b.isEmpty())
        {
            return "0";
        }
        
        int addZeros = Math.abs(a.length() - b.length());
        char []zeros = new char[addZeros];
        Arrays.fill(zeros, '0');
        StringBuffer sb = new StringBuffer();
        sb.append(zeros);
        String formatedStrA = a;
        String formatedStrB = b;
        if(a.length() < b.length())
        {
            formatedStrA = sb.append(a).toString();
        }
        else
        {
            formatedStrB = sb.append(b).toString();
        }
        
        int carryOut = 0;
        StringBuffer ret = new StringBuffer();
        for(int i = formatedStrA.length()-1; i> -1; i--)
        {
            int val1 = formatedStrA.charAt(i) - '0';
            int val2 = formatedStrB.charAt(i) - '0';
            int val = (val1^val2)^carryOut;
            carryOut = (val1&val2)|(val1&carryOut)|(val2&carryOut);
            ret.insert(0, (char)(val+'0'));
        }
        if(carryOut==1)
        {
            ret.insert(0, carryOut);
        }
        
        return ret.toString();
    }
}