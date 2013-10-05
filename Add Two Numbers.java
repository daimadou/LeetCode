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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode node = new ListNode(0);
        ListNode ret = node;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int carryOut = 0;
        while(cur1 != null || cur2 != null)
        {
            int val1 = 0;
            if(cur1 != null)
            {
                val1 = cur1.val;
                cur1 = cur1.next;
            }
            int val2 = 0;
            if(cur2 != null)
            {
                val2 = cur2.val;
                cur2 = cur2.next;
            }
            
            int val = val1 + val2 + carryOut;
            int digit = val%10;
            carryOut = val/10;
            node.next = new ListNode(digit);
            node = node.next; 
        }
        if(carryOut != 0)
        {
            node.next = new ListNode(carryOut);
        }
        return ret.next;
    }
}