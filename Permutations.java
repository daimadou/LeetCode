public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function  
        ArrayList<ArrayList<Integer>> premutations = new ArrayList<ArrayList<Integer>>();
        premutations.add(new ArrayList<Integer>());
        for(int n:num)
        {
            premutations = insert(n, premutations);
        }
        return premutations;
    }
    
    private ArrayList<ArrayList<Integer>> insert(int n, ArrayList<ArrayList<Integer>> premutations)
    {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        for(ArrayList<Integer> premutation: premutations)
        {
            for(int i = 0; i <= premutation.size(); i++)
            {
                ArrayList<Integer> p = new ArrayList<Integer>(premutation);
                p.add(i, n);
                ret.add(p);
            }
        }
        return ret;
    }
    
}