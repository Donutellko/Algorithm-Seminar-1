package seminar1.collections;

import java.util.Iterator;

public class LinkedQueue<Item> implements IQueue<Item> {

	// -> [tail -> .. -> .. -> head] ->
	private Node<Item> head;
	private Node<Item> tail;
	private int size;

	@Override
	public void enqueue(Item item) {

		Node<Item> node = new Node<>(item);

		if (head == null) { // если очередь пуста
			head = tail = node;
		} else { // если не пуста, добавляем в конец
			tail.next = node;
			tail = node;
		}

		size++;
	}

	@Override
	public Item dequeue() {
		if (head == null)
			return null;
		Item result = head.item;

		head = head.next;

		if (size == 1) tail = null;
		size--;

		return result;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterator<Item> iterator() {
		return new LinkedQueueIterator();
	}

	private class LinkedQueueIterator implements Iterator<Item> {

		Node<Item> current = head;

		@Override
		public boolean hasNext() {
			return !(size == 0 || current == null || current.next == null);
		}

		@Override
		public Item next() {
			if (!hasNext())
				return null;
			current = current.next;
			return current.item;
		}

	}

	private static class Node<Item> {
		Item item;
		Node<Item> next;

		Node(Item item) {
			this.item = item;
		}

		public Node(Item item, Node<Item> next) {
			this.item = item;
			this.next = next;
		}
	}
}
