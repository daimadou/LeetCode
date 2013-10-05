/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(head == null)
        {
            return null;
        }
        
        HashMap<RandomListNode, RandomListNode> nodeMap = new HashMap<RandomListNode, RandomListNode>();
        nodeMap.put(head, new RandomListNode(head.label));
        RandomListNode cur = head;
        while(cur != null)
        {
            RandomListNode nodeCopy = nodeMap.get(cur);
            RandomListNode nextCopy = null;
            RandomListNode randomCopy = null;
            if(cur.random != null)
            {
                if(nodeMap.containsKey(cur.random))
                {
                    randomCopy = nodeMap.get(cur.random);
                }
                else
                {
                    randomCopy = new RandomListNode(cur.random.label);
                    nodeMap.put(cur.random, randomCopy);
                }            
            }
            if(cur.next != null)
            {
                if(nodeMap.containsKey(cur.next))
                {
                    nextCopy = nodeMap.get(cur.next);
                }
                else
                {
                    nextCopy = new RandomListNode(cur.next.label);
                    nodeMap.put(cur.next, nextCopy);
                } 
            }
            nodeCopy.next = nextCopy;
            nodeCopy.random = randomCopy;
            cur = cur.next;
        }
        
        return nodeMap.get(head);
    }
}