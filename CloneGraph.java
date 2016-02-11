/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class CloneGraph {
    
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        
        HashSet<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        
        DFSFirstPass(node, set, map);
        
        set.clear();
        
        DFSSecondPass(node, set, map);
        
        return map.get(node);
        
    }
    
    
    public void DFSSecondPass(UndirectedGraphNode n, HashSet<UndirectedGraphNode> isVisited, HashMap<UndirectedGraphNode, UndirectedGraphNode> map){
        
        if(n == null)
            return;
        
        if(!isVisited.contains(n)){
            isVisited.add(n);
            
            // for each of the neighbors in the node, adds the neighbors in the deepCopy
            for(UndirectedGraphNode neighbor : n.neighbors){
                map.get(n).neighbors.add(map.get(neighbor));
                DFSSecondPass(neighbor, isVisited, map);
            }
        }
        
    }
    
    public void DFSFirstPass(UndirectedGraphNode n, HashSet<UndirectedGraphNode> isVisited, HashMap<UndirectedGraphNode, UndirectedGraphNode> map){
        
        if(n == null)
            return;
        
        if(!isVisited.contains(n)){
            isVisited.add(n);
            
            UndirectedGraphNode deepCopy =  new UndirectedGraphNode(n.label);
            deepCopy.neighbors = new ArrayList<UndirectedGraphNode>();
            
            // creates a deep copy of the node and puts in the value
            map.put(n, deepCopy);
            
            for(UndirectedGraphNode neighbor : n.neighbors){
                DFSFirstPass(neighbor, isVisited, map);
            }
        }
        
        
    }
}