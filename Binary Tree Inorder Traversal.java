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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        ArrayList<Integer> ret = new ArrayList<Integer>();
        while(!nodeStack.isEmpty()||root != null)
        {
            if(root != null)
            {
                nodeStack.push(root);
                root = root.left;
            }
            else
            {
                root = nodeStack.pop();
                ret.add(root.val);
                root = root.right;
            }
        }
        
        return ret;
    }
}