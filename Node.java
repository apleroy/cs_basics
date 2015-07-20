
public class Node {

	private int key;
	private String name;
	
	private Node leftChild;
	private Node rightChild;
	
	public Node(int key, String name) {
		this.setKey(key);
		this.setName(name);
	}

	public String getName() {
	    return name;
    }

	public void setName(String name) {
	    this.name = name;
    }

	public int getKey() {
	    return key;
    }

	public void setKey(int key) {
	    this.key = key;
    }

	public Node getLeftChild() {
	    return leftChild;
    }

	public void setLeftChild(Node leftChild) {
	    this.leftChild = leftChild;
    }

	public Node getRightChild() {
	    return rightChild;
    }

	public void setRightChild(Node rightChild) {
	    this.rightChild = rightChild;
    }
	
	public String toString() {
		return this.name + " has the key " + this.key;
	}
}
