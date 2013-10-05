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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i ++)
        {
            indexMap.put(inorder[i], i);
        }
        
        return buildTree(postorder, postorder.length, 0, 0, indexMap);
    }
    
    public TreeNode buildTree(int []postorder, int size, int start, int offset, HashMap<Integer, Integer> indexMap)
    {
        if(size < 1)
        {
            return null;
        }
        
        int lastIndex = start + size - 1;
        int val = postorder[lastIndex];
        int leftSize = indexMap.get(val) - offset;
        int rightSize = size - leftSize - 1;
        TreeNode root = new TreeNode(val);
        root.left = buildTree(postorder, leftSize, start, offset, indexMap);
        root.right = buildTree(postorder, rightSize, start + leftSize, offset + leftSize + 1, indexMap);
        return root;
    }
}