package seminar1.collections;

import java.util.Iterator;

public class LinkedStack<Item> implements IStack<Item> {

    private Node<Item> head;
    private int size;

    @Override
    public void push(Item item) {
        size++;
        Node<Item> new_head = new Node<>(item, null);
        new_head.next = head;
        head = new_head;
    }

    @Override
    public Item pop() {
        if (size == 0) return null;

        size--;
        Node<Item> new_head = head.next;
        Item result = head.item;
        head = new_head;
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
        return new LinkedStackIterator();
    }

    private class LinkedStackIterator implements Iterator<Item> {
		Node<Item> current;

		LinkedStackIterator() {
			current = head;
		}

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public Item next() {
			if (current == null) return null;

			current = current.next;
			return current.item;
        }

    }

    private static class Node<Item> {
        Item item;
        Node<Item> next;

        Node(Item item, Node<Item> next) {
            this.item = item;
            this.next = next;
        }
    }
}
