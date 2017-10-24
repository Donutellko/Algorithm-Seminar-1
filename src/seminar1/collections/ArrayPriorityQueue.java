package seminar1.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class ArrayPriorityQueue<Key extends Comparable<Key>> implements IPriorityQueue<Key> {

    private static final int DEFAULT_CAPACITY = 16;

    private Key[] elementData;
    private Comparator<Key> comparator;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayPriorityQueue() {
        elementData = (Key[]) new Object[DEFAULT_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    public ArrayPriorityQueue(Comparator<Key> comparator) {
        elementData = (Key[]) new Object[DEFAULT_CAPACITY];
        this.comparator = comparator;
    }

    @Override
    public void add(Key key) {
        grow();

    }

    @Override
    public Key peek() {
        /**
         * Посмотреть на минимальный элемент
         */
        if (isEmpty()) {
            return null;
        }
        return elementData[0];
    }

    @Override
    public Key extractMin() {
        /**
         * TODO: implement it — O(log n)
         * Достать минимальный элемент
         *  и перестроить кучу
         */
        shrink();
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void siftUp() {
        /**
         * TODO: implement it — O(log n)
         * Просеивание вверх —
         *  подъём элемента больше родителей
         */
    }

    private void siftDown() {
        /**
         * TODO: implement it — O(log n)
         * Просеивание вниз
         *  спуск элемента меньше детей
         */
    }

    private void grow() {
        /**
         * Если массив заполнился,
         * то увеличить его размер в полтора раз
         */
        if (size == elementData.length - 1) {
            int newCapacity = elementData.length + elementData.length / 2;
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

    private void shrink() {
        /**
         * Если количество элементов в четыре раза меньше,
         * то уменьшить его размер в два раза
         */
        if (size * 4 <= elementData.length) {
            int newCapacity = elementData.length / 2;
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

    private boolean greater(int i, int j) {
        return comparator == null
                ? elementData[i].compareTo(elementData[j]) > 0
                : comparator.compare(elementData[i], elementData[j]) > 0
                ;
    }

    @Override
    public Iterator<Key> iterator() {
        /* TODO: implement it */
        return null;
    }
}
