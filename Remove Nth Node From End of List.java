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
    class NodeData
    {
        ListNode node;
        int level;
        NodeData(ListNode node, int level)
        {
            this.node = node;
            this.level = level;
        }
    }
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return rebuildList(head, n).node;    
    }
    
    private NodeData rebuildList(ListNode cur, int n)
    {
        if(cur == null)
        {
            return new NodeData(null, 0);
        }
        else
        {
            NodeData nodeData= rebuildList(cur.next, n);
            int level = nodeData.level + 1;
            ListNode node = nodeData.node;
            if(level==n)
            {
                cur.next = null;
            }
            else
            {
                cur.next = node;
                node = cur;
            }
            return new NodeData(node, level);
        }
    }
}