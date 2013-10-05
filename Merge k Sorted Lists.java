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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        Comparator comparator = new Comparator<ListNode>
        {
            @Overrride
            public int compare(ListNode a, ListNode b){
                if(a.val < b.val) return -1;
                else if(a.val == b.val) return 0;
                else return 1;
            }
        };
        PriorityQueue<ListNode> Q = new PriorityQueue<ListNode>(1, comparator);
        for(ListNode node: lists)
        {
            if(node != null)
            {
                Q.add(node);                
            }
        }
        
        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode cur = head;
        while(!Q.isEmpty())
        {
            ListNode val = Q.poll();
            cur.next = val;
            if(val.next!=null)
            {
                Q.add(val.next);
            }
            cur = cur.next;
        }
        return head.next;
        
    }
}