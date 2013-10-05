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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++)
        {
            indexMap.put(inorder[i], i);
        }
        
        return buildTree(preorder, preorder.length, 0, 0, indexMap);
    }
    
    public TreeNode buildTree(int[] preorder, int size, int start, int offset, HashMap<Integer, Integer> indexMap)
    {
        if(size < 1)
        {
            return null;
        }
        int val = preorder[start];
        TreeNode root = new TreeNode(val);
        int index = indexMap.get(val);
        int leftSize = index - offset;
        int rightSize = size - leftSize - 1;
        root.left = buildTree(preorder, leftSize, start + 1, offset, indexMap);
        root.right = buildTree(preorder, rightSize, start + leftSize + 1, offset + leftSize + 1,  indexMap);
        return root;
    }
    
    
}