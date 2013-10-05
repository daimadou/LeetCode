/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return generateTrees(1, n);
    }
    
    public ArrayList<TreeNode> generateTrees(int start, int end)
    {
        ArrayList<TreeNode> ret = new ArrayList<TreeNode>();  
        if(start > end)
        {
            ret.add(null);
            return ret;
        }
        
        for(int i = start; i < end + 1; i++)
        {
            ArrayList<TreeNode> leftBranches = generateTrees(start, i-1);
            ArrayList<TreeNode> rightBranches = generateTrees(i+1, end);
            for(TreeNode left:leftBranches)
            {
                for(TreeNode right:rightBranches)
                {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    ret.add(root);
                }
            }
            
        }
        
        return ret;
    }
    
}