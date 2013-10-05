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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        getZigzagOrder(root, 1, ret);
        return ret;
    }
    
    private void getZigzagOrder(TreeNode root, int level, ArrayList<ArrayList<Integer>> ret)
    {
        if(root == null)
        {
            return;
        }
        
        if(level > ret.size())
        {
            ret.add(new ArrayList<Integer>());
        }
        int lastPos = ret.get(level - 1).size();
        lastPos = lastPos > 0? lastPos: 0;
        int insertPos = level%2==1? lastPos : 0;
        ret.get(level-1).add(insertPos, root.val);
        getZigzagOrder(root.left, level + 1, ret);
        getZigzagOrder(root.right, level + 1, ret);
    }
}