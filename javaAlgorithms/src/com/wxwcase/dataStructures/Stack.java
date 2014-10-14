package com.wxwcase.dataStructures;

public class Stack {

	public Stack() {
		this.head = new Node(-1);
	}

	public void push(int data) {
		if(head == null) {
			head = new Node(-1);
		} else if(head.getData() == -1) {
			head.setData(data);
		} else {
			Node node = new Node(data);
			node.setNext(head);
			head = node;
		}
	}

	public int pop() {
		if(head == null)
			throw new EmptyStackException("Stack empty");
		else {
			int data = head.getData();
			head = head.getNext();
			return data;
		}
	}	

	public int top() {
		if(head == null)
			return -1; // return null;
		else
			return head.getData();
	}

	public boolean isEmpty() {
		if(head == null)
			return true;
		else 
			return false;
	}

	public boolean deleteStack() {
		head = null;
		return true;
	}

	private Node head;
}

class Node {
	
	public Node(int data) {
		this.data = data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getNext() {
		return next;
	}

	private int data;
	private Node next;
}

class EmptyStackException extends RuntimeException {
	public EmptyStackException() {
		super();
	}
	
	public EmptyStackException(String message) {
		super(message);
	}
	
	public EmptyStackException(String message, Throwable cause) {
		super(message, cause);
	}
}