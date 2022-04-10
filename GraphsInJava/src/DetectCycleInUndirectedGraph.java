/*
 TC : O(V+E)
 SC : O(V+E) + O(N) + O(N)
 
 */

//Detect cycle in an undirected graph using BFS

import java.util.*;
public class DetectCycleInUndirectedGraph {

	public static void main(String[] args) 
	{
		int V = 4;
	    @SuppressWarnings("unchecked")
	    ArrayList <Integer> adj[] = new ArrayList[V];
	    for(int i = 0; i < 4; i++)
	      adj[i] = new ArrayList<Integer>();
	 
	    addEdge(adj, 0, 1);
	    addEdge(adj, 1, 2);
	    addEdge(adj, 2, 0);
	    addEdge(adj, 2, 3);
	 
	    if (isCyclicDisconntected(adj, V))
	      System.out.println("Yes, cycle is present");
	    else
	      System.out.println("No, cycle is not present");
        
	}
	
	static void addEdge(ArrayList<Integer> adj[], int u, int v)
	  {
	    adj[u].add(v);
	    adj[v].add(u);
	  }
	
	static boolean isCyclicConntected(ArrayList<Integer> adj[], int s, int V, boolean visited[])
	{
		
		int parent[] = new int[V];
	    Arrays.fill(parent, -1);// set parent vertex of every vertex as -1
	    
	    Queue<Integer> q = new LinkedList<>();
	    
	    //mark the current node as visited and then put it into the queue
	    visited[s] = true;
	    q.add(s);
	    
	    while (!q.isEmpty())
	    {
	    	//pop vertices from queue
	    	int u = q.poll();
	    	
	    	// Get all adjacent vertices of the dequeued vertex u. If a adjacent has not been visited, then mark it visited
	        // and push it. Also keep track of the parent so that parent is not considered for cycle.
	    	for (int i = 0; i < adj[u].size(); i++)
	        {
	          int v = adj[u].get(i);
	          if (!visited[v])
	          {
	            visited[v] = true;
	            q.add(v);
	            parent[v] = u;
	          }
	          else if (parent[u] != v)
	            return true;
	        }
	      }
	      return false;
	   }
	
	static boolean isCyclicDisconntected(ArrayList<Integer> adj[], int V)
	{
		boolean visited[] = new boolean[V];
	    Arrays.fill(visited,false);
	 
	    for (int i = 0; i < V; i++)
	      if (!visited[i] &&
	          isCyclicConntected(adj, i, V, visited))
	        return true;
	    return false;
	}

}
