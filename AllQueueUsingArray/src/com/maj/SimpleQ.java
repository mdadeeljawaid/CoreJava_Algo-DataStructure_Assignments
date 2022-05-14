package com.maj;

public class SimpleQ {
	private int capacity;
	int queueArr[];
	int front;
	int rear;
	int currentSize = 0;

	public SimpleQ(int sizeOfQueue) {
		this.capacity = sizeOfQueue;
		front = 0;
		rear = -1;
		queueArr = new int[this.capacity];
	}

	public void enqueue(int data) throws OverFlowException {
		if (isFull()) {
			throw new OverFlowException();
		}
		else {
			rear++;
			if (rear == capacity - 1) {
				rear = 0;
			}
			queueArr[rear] = data;
			currentSize++;
			System.out.println(data + " added to the queue");
		}
	}

	public void dequeue() throws UnderFlowException {
		if (isEmpty()) {
			throw new UnderFlowException();
		}
		else {
			front++;
			if (front == capacity - 1) {
				System.out.println(queueArr[front - 1] + " removed from the queue");
				front = 0;
			} else {
				System.out.println(queueArr[front - 1] + " removed from the queue");
			}
			currentSize--;
		}
	}

	public boolean isFull() {
		if (currentSize == capacity) {
			return true;
		}
		return false;
	}

	public boolean isEmpty() {

		if (currentSize == 0) {
			return true;
		}
		return false;
	}
}
