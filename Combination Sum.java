public class Solution {
    ArrayList<ArrayList<Integer>> ret;
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(candidates);
        ret = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> combination = new ArrayList<Integer>(); 
        _combinationSum(candidates, 0, target, combination);
        return ret;
    }
    
    private void _combinationSum(int[] candidates, int index, int target, ArrayList<Integer>combination)
    {
        if(target<=0 || index == candidates.length)
        {
            if(target==0)
            {
                ret.add(new ArrayList<Integer>(combination));                
            }
            return;
        }
        int val = candidates[index];
        int startIndex = combination.size();
        for(int i = 0; i*val <= target; i++)
        {
            if(i>0)
            {
                combination.add(val);
            }
            _combinationSum(candidates, index +1 ,target - i*val, combination);
        }
        combination.subList(startIndex, combination.size()).clear();
      
    }
}