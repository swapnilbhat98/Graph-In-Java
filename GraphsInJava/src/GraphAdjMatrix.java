import java.util.*;
public class GraphAdjMatrix {

	public static void main(String[] args) {
		// Representation of a graph as an adjacency matrix
		int n = 3, m = 3;
		int adjMat[][] =  new int[n+1][m+1];
		
		// edge 1-->2
		adjMat[1][2] = 1;
		adjMat[2][1] = 1;
		
		//edge 2-->3
		adjMat[2][3] = 1;
		adjMat[3][2] = 1;
		
		//edge 1-->3
		adjMat[1][3] = 1;
		adjMat[3][1] = 1;
		
		for(int i=1;i<n;i++)
		{
			for(int j=0;j<m;j++)
				System.out.println(adjMat[i][j]);
				
		}
		
		

	}

}
