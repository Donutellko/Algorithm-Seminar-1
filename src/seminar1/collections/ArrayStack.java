package seminar1.collections;

import java.util.Arrays;
import java.util.Iterator;

@SuppressWarnings("unchecked")
public class ArrayStack<Item> implements IStack<Item> {

    private static final int DEFAULT_CAPACITY = 10;

    private Item[] elementData;
    private int size;

    public ArrayStack() {
        this.elementData = (Item[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void push(Item item) {
		grow();
		elementData[++size] = item;
    }

    @Override
    public Item pop() {
        if (size == 0) return null;

        Item result = elementData[size--];
        shrink();

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

	private void grow() {
        /*
         * Если массив заполнился,
         * то увеличить его размер в полтора раз
         */

		if (size < elementData.length) return;

		changeCapacity((int) Math.ceil(elementData.length * 1.5d));
    }

    private void shrink() {
        /*
         * Если количество элементов в четыре раза меньше,
         * то уменьшить его размер в два раза
         */

		if (size * 4 < elementData.length) return; // не доверяем тому, кто вызывает

		changeCapacity(elementData.length / 4);
    }

    private void changeCapacity(int newCapacity) {
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayStackIterator();
    }

    private class ArrayStackIterator implements Iterator<Item> {

        private int currentPosition = size;

        @Override
        public boolean hasNext() {
            return currentPosition != 0;
        }

        @Override
        public Item next() {
            return elementData[--currentPosition];
        }

    }

}
