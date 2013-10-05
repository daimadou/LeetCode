public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ret.add(new ArrayList<Integer>());
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> retCopy = null;
        for(int i = 0; i < num.length; i++)
        {
            int pre = (i> 0)? num[i-1]:num[i] - 1;
            if(num[i] != pre)
            {
                retCopy = cloneArrayList(ret);
            }
            for(ArrayList<Integer> al: retCopy)
            {
                al.add(num[i]);
                ret.add((ArrayList<Integer>)al.clone());
            }
        }
        
        return ret;
    }
    
    ArrayList<ArrayList<Integer>> cloneArrayList(ArrayList<ArrayList<Integer>> arrayList)
    {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        for(ArrayList<Integer> elem: arrayList)
        {
            ret.add((ArrayList<Integer>)elem.clone());
        }
        return ret;
    }
}