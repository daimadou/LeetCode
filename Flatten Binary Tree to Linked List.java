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
    private TreeNode pre;
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        pre = null;
        flatTreeNode(root);
    }
    
    private void flatTreeNode(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        flatTreeNode(root.right);
        flatTreeNode(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
        
    }
}