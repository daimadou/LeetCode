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
    int maxVal;
    public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        maxVal = Integer.MIN_VALUE;
        findMaxSum(root);
        return maxVal;
        
    }
    
    private int findMaxSum(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        else
        {
            int left = findMaxSum(root.left);
            int right = findMaxSum(root.right);
            left = left>0? left:0;
            right = right>0? right:0;
            int val = left + right + root.val;
            maxVal = Math.max(maxVal, val);
            int maxBranch = Math.max(left, right);
            return maxBranch + root.val;
            
        }
    }
}