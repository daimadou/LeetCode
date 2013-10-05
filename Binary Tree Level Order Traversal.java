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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        getLevelOrder(root, 1, ret);
        return ret;
    }
    
    private void getLevelOrder(TreeNode root, int level, ArrayList<ArrayList<Integer>> ret)
    {
        if(root == null)
        {
            return;
        }
        
        if(level > ret.size())
        {
            ret.add(new ArrayList<Integer>());
        }
        ret.get(level-1).add(root.val);
        getLevelOrder(root.left, level + 1, ret);
        getLevelOrder(root.right, level + 1, ret);
    }
    
}