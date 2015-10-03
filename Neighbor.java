
//a Neighbor is a Node in the linkedList
//the idea of a neighbor is very similar to a join record, stored in linked list format
//neighbors carry the id of the initial user, and a reference to the next Neighbor
public class Neighbor {

	private int vertexNum;
	private Neighbor next;
	
	
	public Neighbor(int vertexNum, Neighbor neighbor) {
		this.setVertexNum(vertexNum);
		this.setNext(neighbor);
	}

	public int getVertexNum() {
	    return vertexNum;
    }

	public void setVertexNum(int vertexNum) {
	    this.vertexNum = vertexNum;
    }

	public Neighbor getNext() {
	    return next;
    }

	public void setNext(Neighbor next) {
	    this.next = next;
    }

}
