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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(l1 == null && l2 == null)
        {
            return null;
        }
        
        ListNode newList = new ListNode(0);
        ListNode cur = newList;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        
        while(cur1!=null && cur2!=null)
        {
            if(cur1.val < cur2.val)
            {
                cur.next = cur1;
                cur1 = cur1.next;
            }
            else
            {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        
        if(cur1 != null)
        {
            cur.next = cur1;
        }
        
        if(cur2 != null)
        {
            cur.next = cur2;
        }
        
        return newList.next;
    }
}