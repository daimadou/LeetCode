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
    public ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null)
        {
            return null;
        }
        ListNode list1 = new ListNode(x-1);
        ListNode list2 = new ListNode(x+1);
        ListNode cur = head;
        ListNode head1 = list1;
        ListNode head2 = list2;
        while(cur != null)
        {
            if(cur.val < x)
            {
                list1.next =cur;
                list1 = cur;
            }
            else
            {
                list2.next = cur;
                list2 = cur;
            }
            cur = cur.next;
        }
        list2.next = null;
        list1.next = head2.next;
        return head1.next;
    }
}