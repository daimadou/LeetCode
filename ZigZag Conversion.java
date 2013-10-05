public class Solution {
    public String convert(String s, int nRows) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int midNum = nRows -2;
        int readNum = midNum > 0? nRows + midNum : nRows;
        StringBuffer[] sb = new StringBuffer[nRows];
        for(int i = 0; i < sb.length; i++)
        {
            sb[i] = new StringBuffer();
        }
        for(int i = 0; i < s.length(); i++)
        {
            int pos = i%readNum;
            char c = s.charAt(i);
            if(pos < nRows)
            {
                sb[pos].append(c);
            }
            else
            {
                int offset = pos - (nRows -1);
                sb[nRows- 1 - offset].append(c);
            }
        }
        StringBuffer ret = new StringBuffer();
        for(StringBuffer strBuffer: sb)
        {
            ret.append(strBuffer);
        }
        return ret.toString();
    }
}