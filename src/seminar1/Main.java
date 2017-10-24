package seminar1;

import seminar1.collections.IQueue;
import seminar1.collections.IStack;
import seminar1.collections.LinkedQueue;
import seminar1.collections.LinkedStack;
import seminar1.collections.TwoStackQueue;

public class Main {

    public static void main(String[] args) {
        System.out.println("LinkedStack");
        IStack<Integer> stack = new LinkedStack<>();
        for (int i = 0; i < 20; i++) {
            stack.push(i);
        }
//        for (int i : stack) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
        for (int i = 0; i < 30; i++) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();

        System.out.println();
        System.out.println("LinkedQueue");
        IQueue<Integer> queue = new LinkedQueue<>();
        for (int i = 0; i < 20; i++) {
            queue.enqueue(i);
        }
//        for (int i : queue) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
        for (int i = 0; i < 30; i++) {
            System.out.print(queue.dequeue() + " ");
        }
        System.out.println();

        System.out.println();
        System.out.println("TwoStackQueue");
        queue = new TwoStackQueue<>();
        for (int i = 0; i < 20; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < 30; i++) {
            System.out.print(queue.dequeue() + " ");
        }
    }
}

/*
	1. Решить задачу ParenthesesSequence
	    Проверить скобочную последовательность на правильность — один вид скобок
	2. Реализовать ArrayStack
	    На саморасширяющемся массиве
	3. Реализовать LinkedStack
	    На односвязном списке
	4. Решить задачу ParenthesesSequenceExt
	    Проверить скобочную последовательность на правильность — три вида скобок
	5. Решить задачу Solver // Аналогичное решение следующему
		Вычислить инфиксное арифметическое выражение — все операции в скобках
	6. Решить задачу SolverExt
		Вычислить инфиксное арифметическое выражение — операции могут быть без скобок
    7. Реализовать LinkedQueue
        На односвязном списке
8. Реализовать TwoStackQueue
    На двух стеках
9. Реализовать CyclicArrayQueue
    На зацикленном саморасширяющемся массиве
10. Решить задачу MergingIncreasingIterator
    Реализовать итератор возвращающий последовательность из двух возрастающих итераторов в порядке возрастания
    11. Реализовать LinkedDeque
        На двусвязном списке
    12. Реализовать CyclicArrayDeque
        На зацикленном саморасширяющемся массиве
13. Реализовать ArrayPriorityQueue -- начат
    На саморасширяющемся массиве
14. Решить задачу MergingPeekingIncreasingIterator
    Реализовать итератор возвращающий последовательность из N возрастающих итераторов в порядке возрастания
 */
