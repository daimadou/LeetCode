/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    public TreeLinkNode preNode;
    public TreeLinkNode nextLevel;
    
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        preNode = null;
        nextLevel = null;
        TreeLinkNode curNode = root;
        while(curNode != null)
        {
            connectNode(curNode.left);
            connectNode(curNode.right);
            if(curNode.next == null)
            {
                curNode = nextLevel; 
                preNode = null;
                nextLevel = null;
            }
            else
            {
                curNode = curNode.next;
            }
        }
    }
    
    private void connectNode(TreeLinkNode node)
    {
        if(node!= null)
        {
            if(nextLevel == null) 
            {
                nextLevel = node;
            }
            if(preNode != null)
            {
                preNode.next = node;
            }
            preNode = node;
        }
    }
}