
//this is a "friend" in the concept of facebook or linkedin
//the vertex stores the name of a person (in a string) and has reference
//to a linkedlist of "friends/connections/neighbors/etc"

public class Vertex {

	private String name;
	private Neighbor adjacencyList;
	
	public Vertex(String name, Neighbor neighbors) {
		this.setName(name);
		this.setAdjacencyList(neighbors);
	}

	public String getName() {
	    return name;
    }

	public void setName(String name) {
	    this.name = name;
    }

	public Neighbor getAdjacencyList() {
	    return adjacencyList;
    }

	public void setAdjacencyList(Neighbor adjacencyList) {
	    this.adjacencyList = adjacencyList;
    }
	
	
}
