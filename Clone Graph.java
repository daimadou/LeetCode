/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(node == null)
        {
            return null;
        }
        
        UndirectedGraphNode copyNode = new UndirectedGraphNode(node.label);  
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        q.add(node);
        HashMap<UndirectedGraphNode, UndirectedGraphNode> nodeMap = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        nodeMap.put(node, copyNode);
        UndirectedGraphNode headCopyNode = copyNode;
        while(!q.isEmpty())
        {
            UndirectedGraphNode cur = q.poll();
            for(UndirectedGraphNode n:cur.neighbors)
            {
                if(!nodeMap.containsKey(n))
                {
                    copyNode = new UndirectedGraphNode(n.label);
                    nodeMap.put(n, copyNode);
                    q.add(n);
                }
                else
                {
                    copyNode = nodeMap.get(n);
                }
                nodeMap.get(cur).neighbors.add(copyNode);
            }
        }
        
        return headCopyNode;
    }
    

}