package seminar1.collections;

import java.util.Iterator;

public class LinkedDeque<Item> implements IDeque<Item> {

	private Node<Item> front;
	private Node<Item> back;
	int size = 0;

	// <-> [back <-> .. <-> .. <-> front] <->
	// prev - cur - next

	@Override
	public void pushFront(Item item) {
		if (front == null) {
			front = back = new Node<>(item);
		} else {
			Node<Item> node = new Node<>(item, front, null);
			front.prev = node;
			front = node;
		}
		size++;
	}

	@Override
	public void pushBack(Item item) {
		if (back == null) {
			front = back = new Node<>(item);
		} else {
			Node<Item> node = new Node<>(item, null, back);
			back.next = node;
			back = node;
		}
		size++;
	}

	@Override
	public Item popFront() {
		if (size == 0)
			return null;

		Item result = front.item;
		front = front.prev;
		if (size == 1)
			back = null;
		size--;

		return result;

	}

	@Override
	public Item popBack() {
		if (size == 0)
			return null;

		Item result = back.item;
		back = back.next;
		if (size == 1)
			front = null;
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
		return new LinkedDequeIterator();
	}

	// from front to back if direction==true
	public Iterator<Item> iterator(boolean direction) {
		return new LinkedDequeIterator(direction);
	}

	class Node<Item> {
		Item item;
		Node<Item> prev, next;

		Node(Item item) {
			this.item = item;
		}

		Node(Item item, Node<Item> prev, Node<Item> next) {
			this.item = item;
			this.prev = prev;
			this.next = next;
		}
	}

	private class LinkedDequeIterator implements Iterator<Item> {
		Node<Item> current;
		boolean direction = true;

		LinkedDequeIterator() {
			current = front;
		}

		// from front to back if direction==true
		LinkedDequeIterator(boolean direction) {
			current = direction ? front : back;
		}

		@Override
		public boolean hasNext() {
			return !(size == 0 || current == null ||
					(direction ? current.next : current.prev) == null);
		}

		@Override
		public Item next() {
			if (!hasNext())
				return null;

			current = direction ? current.next : current.prev;
			return current.item;
		}
	}
}
