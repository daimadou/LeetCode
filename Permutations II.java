public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> premutations = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> premutation = new ArrayList<Integer>();
        boolean []track = new boolean[num.length]; 
        Arrays.sort(num);
        insert(num, track, premutation, premutations);
        return premutations;
    }
    
    private void insert(int []num, boolean []track, ArrayList<Integer> premutation,  ArrayList<ArrayList<Integer>> premutations)
    {
        if(premutation.size()==num.length)
        {
            premutations.add((ArrayList<Integer>)premutation.clone());
            return;
        }
        
        for(int i = 0; i < num.length; i++)
        {
            if(track[i]||(i > 0 && num[i]==num[i-1] && !track[i-1])) continue;
            track[i] = true;
            premutation.add(num[i]);
            insert(num, track, premutation, premutations);
            premutation.remove(premutation.size() - 1);
            track[i] = false;
        }
    }
}