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
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> levelList = new ArrayList<ArrayList<Integer>>();
        dfs(root, 1, levelList);
        Collections.reverse(levelList);
        return levelList;
    }
    
    private void dfs(TreeNode root, int level, ArrayList<ArrayList<Integer>> levelList)
    {
        if(root == null)
        {
            return;
        }
        
        if(level > levelList.size())
        {
            levelList.add(new ArrayList<Integer>());
        }
        
        levelList.get(level-1).add(root.val);
        dfs(root.left, level + 1, levelList);
        dfs(root.right, level + 1, levelList);
    }
}