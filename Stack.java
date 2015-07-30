
public class Stack {

	private LLNode top;
	
	public Stack() {
		this.setTop(null);
	}
	
	public Stack(LLNode top) {
		this.setTop(top);
	}
	
	public LLNode getTop() {
	    return top;
    }


	public void setTop(LLNode top) {
	    this.top = top;
    }
	
	public LLNode pop() {
		if (this.getTop() != null) {
			LLNode item = this.getTop();
			this.setTop(this.getTop().getNext());
			return item;
		}
		return null;
	}
	
	public void push(int d) {
		LLNode n = new LLNode(d);
		n.setNext(this.getTop());
		this.setTop(n);
	}
	
	public LLNode peek() {
		return this.getTop();
	}
	
	public void print(LLNode top) {
		LLNode current = top;
		while (current != null) {
			System.out.println(current.getData());
			current = current.getNext();
		}
	}
	
	public static void main(String[] args) {
		
		Stack stack = new Stack();
		stack.push(12);
		stack.push(13);
		stack.push(14);
		
		stack.print(stack.getTop());
		
		System.out.println(stack.peek().getData());

		System.out.println(stack.pop().getData());
		System.out.println(stack.pop().getData());


	}


	
}
