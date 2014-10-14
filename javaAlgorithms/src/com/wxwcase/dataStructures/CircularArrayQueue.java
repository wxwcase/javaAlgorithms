package com.wxwcase.dataStructures;

public class CircularArrayQueue implements Queue {	
	// from: http://oppansource.com/queue-implementation-in-java-using-circular-array/
	public CircularArrayQueue() {
		this(capacity);
	}

	public CircularArrayQueue(int capacity) {
		N = capacity;
		Q = new Object[N];
	}

	public int size() {
		if(r > f)
			return r - f;
		return N - f + r;
	}
	
	public boolean isEmpty() {
		return r == f;
	}

	public boolean isFull() {
		int diff = r - f;
		if(diff == -1 || diff == (N - 1))
			return true;
		return false;
	}

	public void enqueue(Object obj) throws QueueFullException {
		if(isFull()) {
			throw new QueueFullException("Queue is full");
		} else {
			Q[r] = obj;
			r = (r + 1) % N;
		}
	}

	public Object dequeue() throws QueueEmptyException {
		Object item;
		if(isEmpty()) {
			throw new QueueEmptyException("Queue is empty");
		} else {
			item = Q[f];
			Q[f] = null;
			f = (f + 1) % N;
		}
		return item;
	}

	private static final int capacity = 5;
	private Object[] Q;
	private final int N; // capacity
	private int f = 0; // f = front
	private int r = 0; // r = rear;
	// rear pointer always point to the slot that to be filled, which means
	// it is always empty in each state
}

interface Queue {
	public int size();
	public boolean isEmpty();
	public boolean isFull();
	public void enqueue(Object obj) throws QueueFullException;
	public Object dequeue() throws QueueEmptyException;
}

class QueueFullException extends RuntimeException {
	public QueueFullException() {
		super();
	}

	public QueueFullException(String message) {
		super(message);
	}

	public QueueFullException(String message, Throwable cause) {
		super(message, cause);
	}
}

class QueueEmptyException extends RuntimeException {
	public QueueEmptyException() {
		super();
	}

	public QueueEmptyException(String message) {
		super(message);
	}

	public QueueEmptyException(String message, Throwable cause) {
		super(message, cause);
	}
}