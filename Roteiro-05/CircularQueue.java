package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;
	private int size;

	@SuppressWarnings("unchecked")
	public CircularQueue(int size) {
		this.array = (T[]) new Object[size];
		this.head = -1;
		this.tail = -1;
		this.elements = 0;
		this.size = size;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(isFull()) {
			throw new QueueOverflowException();
		}
		if(element != null) {
			if(isEmpty()) {
				this.head = 0;
				this.tail = 0;
				this.array[0] = element;
			}else {
				this.tail = ((tail + 1) % size);
				this.array[tail] = element;
			}
			this.elements++;
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(isEmpty()) {
			throw new QueueUnderflowException();
		}
		T value = this.array[head];
		if(this.head == this.tail) {
			this.head = -1;
			this.tail = -1;
		}else {
			this.head = ((this.head + 1) % size);
		}
		this.elements--;
		return value;
	}

	@Override
	public T head() {
		T value = null;
		if(!isEmpty()) {
			value = this.array[head];
		}
		return value;
	}

	@Override
	public boolean isEmpty() {
		return this.elements == 0;
	}

	@Override
	public boolean isFull() {
		return this.elements == this.size;
	}
}
