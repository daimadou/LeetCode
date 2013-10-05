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
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int lastIndex = num.length - 1;
        return sortedArrayToBST(num, 0, lastIndex);
    }
    
    
    public TreeNode sortedArrayToBST(int[] num, int start, int end)
    {
        if(start > end)
        {
            return null;
        }
        
        int mid = start + (end - start)/2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBST(num, start, mid - 1);
        root.right = sortedArrayToBST(num, mid + 1, end);
        return root;
    }
    
}