/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) 
            return node;
        else 
            return DFS(node, new HashMap());
    }
    public UndirectedGraphNode DFS(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> hm)
    {
        if(hm.containsKey(node)) return hm.get(node);
        UndirectedGraphNode nd = new UndirectedGraphNode(node.label);
        hm.put(node, nd);
        for(UndirectedGraphNode tmp : node.neighbors)
            nd.neighbors.add(DFS(tmp, hm));
        
        return nd;
    }
}
