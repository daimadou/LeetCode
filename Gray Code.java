public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int count = 1<<n;
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for(int i = 0; i < count; i++)
        {
            int graycode = i^i>>1;
            ret.add(graycode);
        }
        return ret;
    }
}