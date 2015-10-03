import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.youtube.com/watch?v=zVrPdF7f4-I
//https://www.dropbox.com/s/cn2u1qjuo9nhslv/Graph.java

public class UndirectedGraph {
	List<Vertex> adjacencyLists;
	
	public UndirectedGraph() {
		adjacencyLists = new ArrayList<Vertex>();
	}
	
	
	public static void main(String[] args) {
		
		String[] names = {"Andy", "Bob", "Michael", "Sue", "Mary", "Michel", "Dave"};
		String[][] relationships = 
			{
				{names[0], names[1]}, //Andy, Bob
				{names[0], names[2]}, //Andy, Michael
				{names[1], names[3]}  //Bob, Sue
			};
		
		System.out.println(Arrays.deepToString(relationships));
		
		UndirectedGraph graph = new UndirectedGraph();
		
		for (int i = 0; i < names.length; i++) {
			Vertex v = new Vertex(names[i], null);
			graph.adjacencyLists.add(v);
		}
		
		
		for (int i = 0; i < relationships.length; i++) {
			
			int v1 = graph.indexForName(relationships[i][0]);
			int v2 = graph.indexForName(relationships[i][1]);
			
			Neighbor n1 = new Neighbor(v2, graph.adjacencyLists.get(v1).getAdjacencyList());
			Neighbor n2 = new Neighbor(v1, graph.adjacencyLists.get(v2).getAdjacencyList());
			
			graph.adjacencyLists.get(v1).setAdjacencyList(n1);
			graph.adjacencyLists.get(v2).setAdjacencyList(n2);

		}
		
		graph.print();
		

	}

	private int indexForName(String name) {
		for (int i = 0; i < this.adjacencyLists.size(); i++) {
			if (this.adjacencyLists.get(i).getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	
	
	public void print() {
        System.out.println();
        for (int i = 0; i < this.adjacencyLists.size(); i++) {
            System.out.print(this.adjacencyLists.get(i).getName());
            Neighbor n = this.adjacencyLists.get(i).getAdjacencyList(); 
            while (n != null) {
                System.out.print(" --> " + this.adjacencyLists.get(n.getVertexNum()).getName());
                n = n.getNext();
            }
            System.out.println("\n");
        }
    }
}
