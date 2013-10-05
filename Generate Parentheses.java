public class Solution {
    ArrayList<String> ret;
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ret = new ArrayList<String>();
        char[] p = new char[n*2];
        buildParenthesisStr(0, p, 0, 0, n);
        return ret;
    }
    
    public void buildParenthesisStr(int i, char[] p, int left, int right, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(i==p.length)
        {
            ret.add(new String(p));
        }
        
        if(left < n)
        {
            p[i] = '(';
            buildParenthesisStr(i+1, p, left+1, right, n);
        }
        
        if(right < left)
        {
            p[i] = ')';
            buildParenthesisStr(i+1, p, left, right+1, n);
        }
    }
}