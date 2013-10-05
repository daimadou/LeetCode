/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
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
    ListNode curNode;
    public TreeNode sortedListToBST(ListNode head) {
        int num = 0;
        curNode = head;
        while(curNode != null)
        {
            num++;
            curNode = curNode.next;
        }
        curNode = head;
        return sortedListToBST(0, num-1);
    }
    
    public TreeNode sortedListToBST(int start, int end)
    {
        if(start> end)
        {
            return null;
        }
        
        int mid = start + (end - start)/2;
        TreeNode left = sortedListToBST(start, mid - 1);
        TreeNode root = new TreeNode(curNode.val);
        curNode = curNode.next;
        TreeNode right = sortedListToBST(mid + 1, end);
        
        root.left = left; 
        root.right = right;
        return root;
    }
}