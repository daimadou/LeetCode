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
    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return isSymmetric(root, root);
      
    }
    
    public boolean isSymmetric(TreeNode leftNode, TreeNode rightNode)
    {
        if((leftNode==null)||(rightNode==null))
        {
            return (leftNode==null)&&(rightNode==null);
        }
        else
        {
            if(leftNode.val == rightNode.val)
            {
                return isSymmetric(leftNode.left, rightNode.right)&&isSymmetric(leftNode.right, rightNode.left);
            }
            else
            {
                return false;
            }
        }
    }
}