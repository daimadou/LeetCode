/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null)
        {
            return null;
        }
        
        Stack<ListNode> nodeStack = new Stack<ListNode>();
        ListNode cur = head;
        while(cur != null)
        {
            nodeStack.push(cur);
            cur = cur.next;
        }
        
        int k = n % nodeStack.size();
        ListNode newHead = head;
        if( k > 0)
        {
            ListNode tail = nodeStack.peek();
            for(int i = 0; i < k; i++)
            {
                nodeStack.pop();
            }
            newHead = nodeStack.peek().next;
            nodeStack.peek().next = null;
            tail.next = head;
        }
        
        return newHead;
    }
}