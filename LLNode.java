
public class LLNode {

	private LLNode next;
	private int data;
	
	public LLNode (int data) {
		this.setData(data);
	}
	
	public LLNode getNext() {
	    return next;
    }
	public void setNext(LLNode next) {
	    this.next = next;
    }
	
	public int getData() {
	    return data;
    }
	public void setData(int data) {
	    this.data = data;
    }
	
	
}
