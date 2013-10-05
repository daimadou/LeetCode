public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        //for dynamic programming if just use one demension array, please use back order so that new result won't depend on new result
        ArrayList<ArrayList<Integer>>ret = new ArrayList<ArrayList<Integer>>();  
        ArrayList<Integer> row = new ArrayList<Integer>();
        for(int i = 0; i < numRows; i++)
        {
            row.add(1);
            for(int j = i-1; j > 0; j--)
            {
                int val = row.get(j-1)+row.get(j);
                row.set(j, val);
            }
            ret.add((ArrayList<Integer>)row.clone());
        }
        
        return ret;
    }
}