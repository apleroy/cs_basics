
public class BinaryTree {
	
	private Node root;

	public Node getRoot() {
	    return root;
    }

	public void setRoot(Node root) {
	    this.root = root;
    }
	
	//add Node to tree
	public void addNode(int key, String name) {
		
		//start by creating a new Node object
		Node newNode = new Node(key, name);
		
		//if the Tree has no root, set the newNode to the root of the tree
		if (root == null) {
			root = newNode;
		} else {
			//start by focusing at the root
			Node currentNode = root;
			Node parent;
			
			//iterate down the tree until the correct leaf - go right or left and keep a reference to the parent
			//once the currentNode is null, add the newNode and set the parentNode left or right Node to the child
			while (true) {
				parent = currentNode;
				
				if (key < currentNode.getKey()) {
					currentNode = currentNode.getLeftChild();
					
					if (currentNode == null) {
						parent.setLeftChild(newNode);
						return;
					}
					
				} else {
					currentNode = currentNode.getRightChild();
					
					if (currentNode == null) {
						parent.setRightChild(newNode);
						return;
					}
				}
			}
			
		}
		
	}
	
	//find a given node given a key
	public Node findNode(int key) {
		Node currentNode = root;
		
		while (currentNode.getKey() != key) {

			if (key < currentNode.getKey()) {
				currentNode = currentNode.getLeftChild();
			} else {
				currentNode = currentNode.getRightChild();
			}
			
			if (currentNode == null) {
				return null;
			}
		}
		
		return currentNode;
	}
	
	//removes the node and replaces it with the left most Node on the right subtree of the deleted node
	public boolean removeNode(int key) {
		
		Node currentNode = root;
		Node parent = root;
		boolean isAtLeftChild = true; //variable for searching
		
		//same code as finding a Node, except keep reference to parent Node all the way down
		//keep reference to last traversal - left/right boolean
		while (currentNode.getKey() != key) {
			
			parent = currentNode; //keep parent reference through iteration
			
			if (key < currentNode.getKey()) {
				isAtLeftChild = true;
				currentNode = currentNode.getLeftChild();
			} else {
				isAtLeftChild = false;
				currentNode = currentNode.getRightChild();
			}
			
			if (currentNode == null) {
				return false;
			}
		}
		
		//at this point we have the currentNode set to the node to delete
		
		//scenario 1 - found Node is a leaf with no children
		if (currentNode.getLeftChild() == null && currentNode.getRightChild() == null) {
			if (currentNode == root) {
				root = null;
			} else if (isAtLeftChild) {
				parent.setLeftChild(null);
			} else {
				parent.setRightChild(null);
			}
			
		}
		//scenario 2 - node has no right child
		else if (currentNode.getRightChild() == null) {
			if (currentNode == root) {
				root = currentNode.getLeftChild();
			}
			//if we went left - set parent's leftChild to currentNode's leftChild
			else if (isAtLeftChild) {
				parent.setLeftChild(currentNode.getLeftChild());
			} 
			//if we went right - set parent's rightChild to currentNode's left child
			else {
				parent.setRightChild(currentNode.getLeftChild());
			}
		}
		//scenario 3 - node has no left child
		else if (currentNode.getLeftChild() == null) {
			if (currentNode == root) {
				root = currentNode.getRightChild();
			}
			//if we went left - set parent's leftChild to currentNode's right child
			else if (isAtLeftChild) {
				parent.setLeftChild(currentNode.getRightChild());
			}
			else {
				parent.setRightChild(currentNode.getRightChild());
			}
		}
		//scenario 4 - parent has right and left children
		//the rightChild of the deleted Node takes the place of the deleted Node
		else {
			Node replacementNode = getReplacementNode(currentNode);
			
			if (currentNode == root) {
				root = replacementNode;
			}
			else if (isAtLeftChild) {
				parent.setLeftChild(replacementNode);
			}
			else {
				parent.setRightChild(replacementNode);
			}
			replacementNode.setLeftChild(currentNode.getLeftChild());
			
		}
		
		
		return true;
	}
	
	public Node getReplacementNode(Node replacedNode) {
		Node replacementParent = replacedNode;
		Node replacement = replacedNode;
		
		Node currentNode = replacedNode.getRightChild();
		
		while (currentNode != null) {
			replacementParent = replacement;
			replacement = currentNode;
			currentNode = currentNode.getLeftChild();
		}
		
		if (replacement != replacedNode.getRightChild()) {
			replacementParent.setLeftChild(replacement.getRightChild());
			replacement.setRightChild(replacedNode.getRightChild());
		}
		
		return replacement;
	}
	
	
	
	//prints all nodes in ascending order
	public void inOrderTraversal(Node currentNode) {
		
		if (currentNode != null) {
			inOrderTraversal(currentNode.getLeftChild());
			System.out.println(currentNode);
			inOrderTraversal(currentNode.getRightChild());
		}
	}
	
	//visit the root node and print
	//visit the left node and print
	//visit the right node and print
	public void preOrderTraversal(Node currentNode) {
		
		if (currentNode != null) {
			System.out.println(currentNode);
			preOrderTraversal(currentNode.getLeftChild());
			preOrderTraversal(currentNode.getRightChild());
		}
	}
	
	//visit all left Nodes
	//visit all right Nodes
	public void postOrderTraversal(Node currentNode) {
		
		if (currentNode != null) {
			postOrderTraversal(currentNode.getLeftChild());
			postOrderTraversal(currentNode.getRightChild());
			System.out.println(currentNode);
		}
	}
	
	public static void main(String[] args) {

		BinaryTree testTree = new BinaryTree();
		
		testTree.addNode(50, "CEO");
		testTree.addNode(25, "VP");
		testTree.addNode(15, "Manager");
		testTree.addNode(30, "Director");
		testTree.addNode(80, "Sales Manager");
		testTree.addNode(85, "Account Executive");
		testTree.addNode(75, "Account Executive");
		testTree.addNode(81, "Account Executive");
		testTree.addNode(79, "Account Executive");
		testTree.addNode(83, "Account Executive");
		testTree.addNode(87, "Account Executive");
		testTree.addNode(70, "Account Executive");


		
		testTree.inOrderTraversal(testTree.root);
		System.out.println();
		testTree.preOrderTraversal(testTree.root);
		
		System.out.println();
		System.out.println(testTree.removeNode(80));
		
		System.out.println();
		testTree.preOrderTraversal(testTree.root);
		
		
	}

}
