
public class Queue {
	
	private LLNode first;
	private LLNode last;
	
	public Queue() {
		this.setFirst(null);
		this.setLast(null);
	}
	
	public Queue(LLNode first) {
		this.setFirst(first);
	}

	public LLNode getFirst() {
	    return first;
    }

	public void setFirst(LLNode first) {
	    this.first = first;
    }

	public LLNode getLast() {
	    return last;
    }


	public void setLast(LLNode last) {
	    this.last = last;
    }
	
	public void enqueue(int d) {
		LLNode node = new LLNode(d);
		if (this.getFirst() == null) {
			this.setFirst(node);
			this.setLast(node);
		} else {
			this.getLast().setNext(node);
			this.setLast(node);
		}
	}
	
	public LLNode dequeue() {
		if (this.getFirst() != null) {
			LLNode node = this.getFirst();
			this.setFirst(this.getFirst().getNext());
			if (this.getFirst() == null) {
				this.setLast(null);
			}
			return node;
		} else {
			return null;
		}
	}
	
	public void print() {
		LLNode current = this.getFirst();
		while (current != null) {
			System.out.print(current.getData() + " ");
			current = current.getNext();
		}
	}
	
	
	
	public static void main(String[] args) {
		
		Queue queue = new Queue();
		queue.enqueue(5);
		queue.enqueue(6);
		queue.enqueue(7);
		queue.print();
		
		System.out.println();
		
		queue.dequeue();
		queue.print();
	}


}
