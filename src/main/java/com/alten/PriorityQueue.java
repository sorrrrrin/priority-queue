package com.alten;

import java.util.stream.IntStream;

public class PriorityQueue<T> {

	/**
	 * Array of generic objects. The Array is used for speed considerations, it
	 * should be faster than ArrayList.
	 */
	private T[] priorityQueue;

	/**
	 * Buffer size for priority queue array
	 */
	private final int BUFFER_SIZE = 4;

	/**
	 * The Constructor initializes the priority queue. It uses a buffer of 4
	 * elements for speed considerations, it should be faster in comparison of
	 * increasing/initializing a new array for every new element.
	 */
	public PriorityQueue() {
		priorityQueue = (T[]) new Object[BUFFER_SIZE];
	}

	/**
	 * Adds a new element to the priority queue.
	 * 
	 * @param element
	 *            The elemen to be added.
	 * @param index
	 *            The index/priority of the element to be added. If it is null,
	 *            it will be added first, with the highest priority.
	 */
	public void add(T element, Integer index) {
		synchronized (priorityQueue) { // synchronized code block to handle
										// multithreding and race conditions
			int length = length();
			if (length == priorityQueue.length) {
				T queueTemp[] = (T[]) new Object[priorityQueue.length + BUFFER_SIZE];
				for (int i = 0; i < priorityQueue.length; i++) {
					queueTemp[i] = priorityQueue[i];
				}

				priorityQueue = queueTemp;
			}

			if (index == null) {
				index = length;
			} else {
				for (int i = length; i > index; i--) {
					priorityQueue[i] = priorityQueue[i - 1];
				}
			}

			priorityQueue[index] = element;
		}
	}

	/**
	 * Retrieves the first element in the priority queue and removes it. If the
	 * queue is empty it returns null
	 * 
	 * @return the first element in the priority queue
	 */
	public T get() {
		synchronized (priorityQueue) { // synchronized code block to handle
										// multithreding and race conditions
			int length = length();
			T obj = priorityQueue[0];

			for (int i = 0; i < priorityQueue.length - 1; i++) {
				priorityQueue[i] = priorityQueue[i + 1];
			}

			if (length == priorityQueue.length) {
				priorityQueue[length - 1] = null;
			}

			return obj;
		}
	}

	/**
	 * Change the priority of an element in the priority queue.
	 *
	 * @param index
	 *            The index of the element to change priority for
	 * @param newIndex
	 *            The new index
	 */
	public void changePriority(int index, int newIndex) {
		synchronized (priorityQueue) { // synchronized code block to handle
										// multithreding and race conditions
			int length = length();
			if (index < 0 || index >= length || newIndex < 0 || newIndex >= length) {
				throw new IndexOutOfBoundsException();
			}

			T obj = priorityQueue[index];

			if (index < newIndex) {
				for (int i = index; i < newIndex; i++) {
					priorityQueue[i] = priorityQueue[i + 1];
				}
			} else if (index > newIndex) {
				for (int i = index; i > newIndex; i--) {
					priorityQueue[i] = priorityQueue[i - 1];
				}
			}
			priorityQueue[newIndex] = obj;
		}
	}

	/**
	 * Returns the size of the priority queue.
	 * 
	 * @return The length of the priority queue.
	 */
	public int length() {
		synchronized (priorityQueue) { // synchronized code block to handle
										// multithreding and race conditions
			int index = IntStream.range(0, priorityQueue.length).filter(i -> priorityQueue[i] == null).findFirst()
					.orElse(priorityQueue.length);

			return index;
		}
	}
}
