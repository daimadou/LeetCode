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
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null)
        {
            return null;
        }
        
        ListNode pre = new ListNode(head.val - 1);
        ListNode newHead = pre;
        ListNode cur = head;
        int preVal = pre.val;
        while(cur!=null)
        {
            int nextVal = cur.next == null? (cur.val + 1):cur.next.val;
            pre.next = cur;
            if(cur.val!=preVal && cur.val != nextVal)
            {
                pre = cur;
            }
            preVal = cur.val;
            cur = cur.next;
        }
        pre.next = null;
        return newHead.next;
    }
}