import java.util.HashSet;
import java.util.Set;


public class LinkedList {
	
	private LLNode head;
	
	public LinkedList(LLNode head) {
		this.setHead(head);
	}
	
	public LinkedList() {
		this.setHead(null);
	}

	public LLNode getHead() {
	    return head;
    }


	public void setHead(LLNode head) {
	    this.head = head;
    }
	
	//O(1)
	public void addNodeToHead(int d) {
		LLNode node = new LLNode(d);
		if (this.getHead() == null) {
			this.setHead(node);
		} else {
			node.setNext(this.getHead());
			this.setHead(node);
		}
	}
	
	//O(n) for singly linkedlist
	//O(1) for doubly linkedlist with reference to tail
	public void addNodeToTail(int d) {
		LLNode node = new LLNode(d);
		LLNode current = this.getHead();
		if (current != null) {
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(node);
		} else {
			this.setHead(node);
		}
	}
	
	//O(n) to search for node to delete
	public LLNode deleteNode(LLNode head, int d) {
		LLNode node = head;
		
		if (node.getData() == d) {
			return head.getNext();
		}
		
		while (node.getNext() != null) {
			if (node.getNext().getData() == d) {
				node.setNext(node.getNext().getNext());
				return head;
			}
			node = node.getNext();
		}
		
		return head;
	}
	
	public LLNode deleteDuplicates(LLNode head) {
		Set<Integer> set = new HashSet<Integer>();
		LLNode current = head;
		LLNode prev = null;
		
		while (current != null) {
			if (set.contains(current.getData())) {
				prev.setNext(current.getNext());
			} else {
				set.add(current.getData());
				prev = current;
			}
			current = current.getNext();
			
		}
		return head;
		
	}
	
	public LLNode findNthNodeFromEnd(LLNode head, int k) {
		
		LLNode node1 = head;
		LLNode nodeRunner = head;
				
		for (int i = 0; i < k; i++) {
			if (nodeRunner == null) {
				return null;
			}
			nodeRunner = nodeRunner.getNext();
		}
		
		while (nodeRunner != null) {
			nodeRunner = nodeRunner.getNext();
			node1 = node1.getNext();
		}
		
		return node1;
		
	}
	
	public void print() {
		LLNode current = this.getHead();
		while (current != null) {
			System.out.print(current.getData() + " ");
			current = current.getNext();
		}
	}
	
	
	
	public static void main(String[] args) {
		
		LinkedList linkedListFront = new LinkedList();
		linkedListFront.addNodeToHead(2);
		linkedListFront.addNodeToHead(3);
		linkedListFront.addNodeToHead(5);
		linkedListFront.addNodeToHead(8);
		linkedListFront.addNodeToHead(13);
		
		linkedListFront.print();
		
		LinkedList linkedListBack = new LinkedList();
		linkedListBack.addNodeToTail(2);
		linkedListBack.addNodeToTail(3);
		linkedListBack.addNodeToTail(5);
		linkedListBack.addNodeToTail(8);
		linkedListBack.addNodeToTail(13);
		linkedListBack.addNodeToTail(5);
		linkedListBack.addNodeToTail(13);
		linkedListBack.addNodeToTail(13);
		
		System.out.println();
		linkedListBack.print();
		
		//linkedListBack.deleteNode(linkedListBack.getHead(), 5);
		System.out.println();
		linkedListBack.print();
		
		System.out.println();
		linkedListBack.deleteDuplicates(linkedListBack.getHead());
		linkedListBack.print();
		
		System.out.println();
		System.out.println(
				linkedListFront.findNthNodeFromEnd(linkedListFront.getHead(), 4)
				.getData()
				);
		
		
		
	}
	
	


	
}
