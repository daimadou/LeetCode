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
    private TreeNode wrongNode1;
    private TreeNode wrongNode2;
    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        wrongNode1 = null; 
        wrongNode2 = null;
        pre = new TreeNode(Integer.MIN_VALUE);
        inOrder(root);
        int val = wrongNode1.val;
        wrongNode1.val = wrongNode2.val;
        wrongNode2.val = val;
    }
    
    private void inOrder(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        
        inOrder(root.left);
        
        if(pre.val > root.val)
        {
            if(wrongNode1 == null)
            {
                wrongNode1 = pre;
            }
            wrongNode2 = root;
        }
        pre = root;
        
        inOrder(root.right);
    }
}