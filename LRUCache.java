import java.util.*;

class Node{
	int k, v;

	Node prev;
	Node next;

	public Node(int k, int v){
		this.k = k;
		this.v = v;
	}
}

public class LRUCache{
	
	int max_size;
	public Node start;
	public Node end;
	HashMap<Integer, Node> map;


	public LRUCache(int max_size){
		this.max_size = max_size;
		start = null;
		end = null;
		map = new HashMap<Integer, Node>();
	}


	public void set(int k, int v) {

        Node node = new Node(k, v);
        
		if(map.containsKey(k)){
			removeNode(map.get(k));
			map.put(k, node);
			addToStart(node);
		}
        else{
    		map.put(k, node);
    		addToStart(node);
    
    		if(map.size() > max_size){
    			map.remove(end.k);
    			removeNode(end);
    		}
        }
	}

	public Integer get(int k){

		if(map.get(k) == null){
			return -1;
		}

		Integer val = map.get(k).v;

		removeNode(map.get(k));
		addToStart(map.get(k));

		return val;

	}

	// adds links to the start
	private void addToStart(Node n){

		if(start == null){
			start = n;
			end = n;
			n.prev = null;
			n.next = null;
		}
		else{
			n.prev = null;
			n.next = start;
			start.prev = n;

			start = n;
		}
	}

	// remove links from the node
	private void removeNode(Node n){
		Node pr = n.prev;
		Node ne = n.next;

		if(pr != null){
			pr.next = ne;

		}

		if(ne != null){
			ne.prev = pr;
		}

		n.next = null;
		n.prev = null;

		// for last element
		if(ne == null){
			end = pr;
		}

		// for first element
		if(pr == null){
			start = ne;
		}
	}


	public static void main(String [] args){
		LRUCache c = new LRUCache(2);
		c.set(2, 1);
		c.set(1, 1);
		c.set(2, 3);
		c.set(4, 1);


		System.out.println(c.get(1));
		System.out.println(c.get(2));
		// assert c.get(3) == 4;
		// assert c.start.k == 3;
		// assert c.end.k == 4;
		// assert c.get(4) == null;
		// assert c.get(6) == 7;

		// AssetEquals
		// System.out.println(c.get(3));
		// System.out.println(c.start.k);
		// System.out.println(c.end.k);
		// System.out.println(c.get(4));

		try{
			c.set(3, 1000);
			assert false;
		}catch(IllegalArgumentException e){
			assert true;
		}

		System.out.println("PASS");

		

	}

}