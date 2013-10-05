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
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode pre = new ListNode(0);
        ListNode newHead = pre;
        pre.next = head;
        int count = 0;
        ListNode cur = head;
        while(cur!=null)
        {
            if(++count%2 == 0)
            {
                ListNode last = pre.next; 
                last.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
                cur = last;
                pre = cur;  
            }
            cur = cur.next;
        }
    
        return newHead.next;
    }
}