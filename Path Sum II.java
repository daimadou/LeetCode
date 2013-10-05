/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(root != null)
        {
            getSum(results, ret, root, 0, sum);
        }
        return results;
    }
    
    private void getSum(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> ret, TreeNode root, int val, int sum)
    {
        val += root.val;
        ret.add(root.val);
        if(root.left==null && root.right==null && val==sum)
        {
            results.add((ArrayList<Integer>)ret.clone());
        }
        if(root.left != null)
        {
            getSum(results, ret, root.left, val, sum);
        }
        if(root.right != null)
        {
            getSum(results, ret, root.right, val, sum);
        }
        int lastIndex = ret.size() - 1;
        ret.remove(lastIndex);
    }
}