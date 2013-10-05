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
    public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean ret = true;
        if(root != null)
        {
            ret = (isBalancedBasedOnDepth(root) == -1)? false: true;
        }
        return ret;
    }
    
    private int isBalancedBasedOnDepth(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        
        int leftDepth = isBalancedBasedOnDepth(root.left);
        int rightDepth = (leftDepth == -1)? -1:isBalancedBasedOnDepth(root.right);
        
        if(leftDepth < 0|| rightDepth < 0 ||Math.abs(leftDepth-rightDepth)>1)
        {
            return -1;
        }
        else
        {
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
}