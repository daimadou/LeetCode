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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int count = 0;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode cur = head; 
        ListNode ret = pre;
        ListNode last = null;
        while(cur != null)
        {
            count++;
            if(count < m)
            {
                pre = cur;
            }
            else if(count == m)
            {
                last = pre.next;
            }
            
            if(count <= m || count > n)
            {
                cur = cur.next;
            }
            else
            {
                last.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
                cur = last.next;
            }
        }
        
        return ret.next;
    }
    
}