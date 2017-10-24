package seminar1.collections;

import java.util.Iterator;

public class CyclicArrayDeque<Item> implements IDeque<Item> {

    private static final int DEFAULT_CAPACITY = 16;

    private Item[] elementData;
    private int size;
    private int tail, head;

    @SuppressWarnings("unchecked")
    public CyclicArrayDeque() {
        elementData = (Item[]) new Object[DEFAULT_CAPACITY];
        tail = 0;
        head = elementData.length - 1;
    }

    @Override
    public void pushFront(Item item) {
        grow();
        if (--tail == -1){
            tail = elementData.length - 1;
        }
        elementData[tail] = item;
        size++;
    }

    @Override
    public void pushBack(Item item) {
        grow();
        if (++head == elementData.length){
            head = 0;
        }
        elementData[head] = item;
        size++;
    }

    @Override
    public Item popFront() {
        shrink();

        Item item = elementData[tail];
        elementData[tail] = null;
        if (++tail == elementData.length){
            tail = 0;
        }
        size--;

        return item;
    }

    @Override
    public Item popBack() {
        shrink();

        Item item = elementData[head];
        elementData[head] = null;
        if (--head == -1){
            head = elementData.length - 1;
        }
        size--;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    private void grow() {
        /**
         * Если массив заполнился,
         * то увеличить его размер в полтора раз
         */
        if (size == elementData.length - 1) {
            changeCapacity(elementData.length + elementData.length / 2);
        }
    }

    private void shrink() {
        /**
         * Если количество элементов в четыре раза меньше,
         * то уменьшить его размер в два раза
         */
        if (size * 4 <= elementData.length) {
            changeCapacity(elementData.length / 2);
        }
    }

    @SuppressWarnings("unchecked")
    private void changeCapacity(int newCapacity) {
        Item[] newElementData = (Item[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElementData[i] = elementData[(tail + i) % elementData.length];
        }
        elementData = newElementData;
        tail = 0;
        head = size - 1;
    }

    @Override
    public Iterator<Item> iterator() {
        return new CyclicArrayDequeIterator();
    }

    private class CyclicArrayDequeIterator implements Iterator<Item> {

        private int currentPosition = tail;

        @Override
        public boolean hasNext() {
            return currentPosition == -1;
        }

        @Override
        public Item next() {
            return null;
        }
    }
}
