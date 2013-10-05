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
    int sum;
    public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        sum = 0;
        if(root!=null)
        {
            findLeefNode(root, 0);
        }
        return sum;
        
    }
    
    private void findLeefNode(TreeNode node, int val)
    {
        val = 10*val + node.val;
        if(node.left==null && node.right==null)
        {
            sum += val;
        }
        else
        {
            if(node.left!=null)
            {
                findLeefNode(node.left, val);
            }
            if(node.right!=null)
            {
                findLeefNode(node.right, val);
            }
        }
    }
}