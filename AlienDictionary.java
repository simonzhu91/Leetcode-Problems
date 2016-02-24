import java.util.*;

public class AlienDictionary{

	// Question: Given a list of words which represent lexigraphical ordering of characters in the alien dictionary
	// Recreate the Alien Dictionary
	// If ordering is invalid, return empty string

	// Idea, in order to determine the order of the alphabet, we know that certain letters must occur before others
	// This idea means that we need to visit certain nodes before others. This is an indication of Topological Sort

	// In order to detect cycles, we use a visited as an integer array
	// visited[i] == 0 // unvisited
	// visited[i] == 1 // visiting
	// visited[i] == 2 // visited
 
	HashMap<Character, HashSet<Character>> map;

	 public String alienOrder(String[] words) {
	 	// 1. creates graph
	 	map = new HashMap<Character, HashSet<Character>>();

	 	for(String s : words){
	 		for(int i = 0; i < s.length()-1; i++){
	 			if(!map.containsKey(s.charAt(i))){
	 				map.put(s.charAt(i), new HashSet<Character>());
	 			}
	 			
	 			// references to itself?
	 			if(s.charAt(i) != s.charAt(i+1))
	 				map.get(s.charAt(i)).add(s.charAt(i+1));
	 		}
	 	}

	 	int [] visited = new int [26];
	 	Stack<Character> order = new Stack<Character>();

	 	for(Character c : map.keySet()){
	 		if(visited[c-'a'] == 0){
	 			boolean result = topologicalSort(c,visited, order);
	 			if(result == false){
	 				return "";
	 			}
	 		}
	 	}

	 	String toRet = "";
	 	while(!order.isEmpty()){
	 		toRet += order.pop();
	 	}

	 	return toRet;

	 }

	 // Topological Sort is very similar to DFS
	 public boolean topologicalSort(Character c, int [] visited, Stack<Character> order){
	 	visited[c-'a'] = 1;

	 	for(Character neigh : map.get(c)){
	 		if(visited[neigh-'a'] == 0){
	 			topologicalSort(neigh, visited, order);
	 		}else if(visited[neigh-'a'] == 1){
	 			return false;
	 		}
	 	}

	 	visited[c-'a'] = 2;
	 	order.add(c);
	 	return true;

	 }

	 public static void main(String [] args){
	 	AlienDictionary a = new AlienDictionary();
	 	String [] words = {"wrt", "wrf", "er", "ett", "rftt"};

	 	System.out.println(a.alienOrder(words));
	 }

}