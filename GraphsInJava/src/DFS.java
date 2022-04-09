import java.util.ArrayList;

public class DFS {
	private int V; // no of vertices
	private ArrayList<ArrayList<Integer>> adj; //Adjacency list
	
	//Constructor
	@SuppressWarnings("unchecked") DFS(int v)
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
    
    void DFSUtil(int v)
    {
    	boolean vis[] = new boolean[V];
    	dfsTraversal(v, vis);
    }
    
    void dfsTraversal(int v, boolean vis[])
    {
    	vis[v] = true;
    	System.out.print(v + " ");
    	
    	for(Integer neighbour : adj.get(v))
    	{
    		if(!vis[neighbour])
    		{
    			dfsTraversal(neighbour, vis);
    		}
    	}
    }

	public static void main(String[] args) {
		
		DFS d = new DFS(4);
		 
        d.addEdge(0, 1);
        d.addEdge(0, 2);
        d.addEdge(1, 2);
        d.addEdge(2, 0);
        d.addEdge(2, 3);
        d.addEdge(3, 3);
 
        System.out.println(
            "Following is Depth First Traversal "
            + "(starting from vertex 2)");
 
        d.DFSUtil(2);
		
	}

}
