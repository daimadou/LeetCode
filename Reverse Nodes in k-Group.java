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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null)
        {
            return null;
        }
        
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode newHead = pre;
        ListNode cur = head;
        int count = 0;
        while(cur != null)
        {
            if(++count == k)
            {
                cur = reverse(pre, cur.next);
                pre = cur;
                count = 0;
            }
            cur = cur.next;
        }
        return newHead.next;
    }
    
    private ListNode reverse(ListNode pre, ListNode end)
    {
        ListNode last = pre.next;
        ListNode cur = last.next;
        while(cur!= end)
        {
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = last.next;
        }
        return last;
    }
}