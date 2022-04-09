/*

TC : O(V+E)
SC : O(V)	
V = no. of vertices
E = no. of edges	

*/

import java.util.*;
public class BFS {
	
	private int V; // no of vertices
	private ArrayList<ArrayList<Integer>> adj; //Adjacency list
	
	//Constructor
	BFS(int v)
	{
		V = v;
		adj = new ArrayList<>();
		for(int i=0;i<v;i++)
		{
			adj.add(new ArrayList<Integer>());
		}
		
		
	}
	
	// Function to add an edge into the graph
    void addEdge(int v,int w)
    {
        adj.get(v).add(w);
    }
	
	void bfsOfGraph(int source)
	{
		// Mark all the vertices as not visited(By default set as false)
        boolean visited[] = new boolean[V];
 
        // Create a queue for BFS
        Queue<Integer> queue = new LinkedList<Integer>();
 
        // Mark the current node as visited and enqueue it
        visited[source]=true;
        queue.add(source);
 
        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            source = queue.poll();
            System.out.print(source+" ");
 
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adj.get(source).listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
	
	  public static void main(String[] args) {
		BFS b = new BFS(4);
		b.addEdge(0, 1);
        b.addEdge(0, 2);
        b.addEdge(1, 2);
        b.addEdge(2, 0);
        b.addEdge(2, 3);
        b.addEdge(3, 3);
		
		
        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 1)");

        b.bfsOfGraph(1);
		

	}

}
