package trees;

import java.util.Scanner;

public class BinaryTree {

	private Node root;
	public BinaryTree() {
		
	}
	private class Node{
		int value;	
		Node left;
		Node right;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	// insert nodes
	
	public void insertRoot() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the root node: ");
		int value = sc.nextInt();
		root = new Node(value);
		insertNodes(root);
	}

	private void insertNodes(Node node) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you want to enter the left node for: "+node.value);
		boolean left = sc.nextBoolean();
		if(left) {
			System.out.println("Enter the value of the left of "+node.value);
			int value = sc.nextInt();
			node.left = new Node(value);
			insertNodes(node.left); 
		}
		
		System.out.println("Do you want to enter the right node for: "+node.value);
		boolean right = sc.nextBoolean();
		if(right) {
			System.out.println("Enter the value of the right of "+node.value);
			int value = sc.nextInt();
			node.right = new Node(value);
			insertNodes(node.right); 
		}
	}
	
	public void display() {
		 display(root,"");
	}
	
	public void display(Node node,String indent) {
		if(node==null) return;
		System.out.println(indent+node.value);
		display(node.left,indent+"\t");
		display(node.right,indent+"\t");
	}
	public void printTree() {
	    printTree(root, 0);
	}
	private void printTree(Node node,int level) {
	    if (node == null) return;
	    printTree(node.right,level+1);
	    if(level!=0) {
	    	for(int i=0;i<level-1;i++) {
	    		System.out.print("|\t\t");
	    	}
	    	System.out.println("|------->"+node.value);
	    }
	    else {
	    	System.out.println(node.value);
	    }
	    printTree(node.left,level+1);
	}
	
	public void preOrder() {
		preOrder(root);
	}
	private void preOrder(Node node) {
		if(node==null) return;
		
		System.out.println(node.value+" ");
		preOrder(node.left);
		preOrder(node.right);
	}
	 
	public void inOrder() {
		inOrder(root);
	}
	private void inOrder(Node node) {
		if(node==null) return;
		
		inOrder(node.left);
		System.out.println(node.value+" ");
		inOrder(node.right);
	}
	
	public void postOrder() {
		postOrder(root);
	}
	private void postOrder(Node node) {
		if(node==null) return;
		
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.value+" ");
	}
}
