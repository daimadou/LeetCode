public class Solution {
    ArrayList<ArrayList<Integer>> ret;
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        ret = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> combination = new ArrayList<Integer>(); 
        _combinationSum2(num, 0, target, combination);
        return ret;
    }
    
    
    private void _combinationSum2(int[] num, int index, int target, ArrayList<Integer>combination)
    {
        if(target<=0 || index == num.length)
        {
            if(target==0)
            {
                ret.add(new ArrayList<Integer>(combination));                
            }
            return;
        }
        int preVal = num[index] - 1;
        for(int i = index; i < num.length; i++)
        {
            int val = num[i];
            if(num[i]!=preVal)
            {
                combination.add(val);
                _combinationSum2(num, i +1 ,target - val, combination);
                combination.remove(combination.size()-1);
            }
            preVal = num[i];
        }
    }
}