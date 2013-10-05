public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> combination = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(k <= n)
        {
            buildCombine(1, n, k, combination, ret);
        }
        return ret;
    }
    
    private void buildCombine(int start, int end, int k, ArrayList<Integer> combination, ArrayList<ArrayList<Integer>> ret)
    {
        if(k==0)
        {
            ret.add((ArrayList<Integer>)combination.clone());
            return;
        }
        for(int i = start; i <= end; i++)
        {
            combination.add(i);
            buildCombine(i+1, end, k-1, combination, ret);
            int lastIndex = combination.size() - 1;
            combination.remove(lastIndex);
        }
    }
}