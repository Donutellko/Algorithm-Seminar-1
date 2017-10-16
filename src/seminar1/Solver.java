package seminar1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) = 101
 * ( 1 + ( 5 * ( 4 * 5 ) ) ) ( 1 + ( 5 * 20 ) ) = 101
 * ( 1 + 100 ) = 101
 *
 * Считаем, что операции деления на ноль отсутствуют
 */
@SuppressWarnings("Duplicates")
public class Solver {

    private static final String QUIT = "q";

    private static final char LEFT_PAREN   = '(';
    private static final char RIGHT_PAREN  = ')';
    private static final char PLUS         = '+';
    private static final char MINUS        = '-';
    private static final char TIMES        = '*';
    private static final char DIVISION     = '/';

    private static int[][] table = new int[][] {
			{ 6, 1, 1, 1 ,1 ,1 ,5 },
			{ 5, 1, 1, 1, 1, 1, 3 },
			{ 4, 1, 2, 2, 1, 1, 4 },
			{ 4, 1, 2, 2, 1, 1, 3 },
			{ 4, 1, 4, 4, 2, 2, 4 },
			{ 4, 1, 4, 4, 2, 2, 4 }
	};

    private static double evaluate(String[] values) {
		Stack<Character> T = new Stack<>();
		Stack<Double> E = new Stack<>();

		for (String value : values) {
			try { // если является числом
				double d = Double.valueOf(value);
				E.add(d);
			} catch (NumberFormatException e) { //если ялвяется оператором
				char cur = value.charAt(0);
				if (!functions(cur, T, E)) return E.peek();
			}
		}
		return E.peek();
    }

    private static boolean functions (char cur, Stack<Character> T, Stack<Double> E) {
		char prev = '$'; // в качестве символа пустой строки
		if (T.size() > 0) prev = T.peek();

		switch (table[operationCode(cur)][operationCode(prev)]) {
			case 1:
				T.add(cur);
				break;
			case 2:
				E.push(apply(E.pop(), T.pop(), E.pop()));
				break;
			case 3:
				T.pop();
				break;
			case 4:
				E.push(apply(E.pop(), T.pop(), E.pop()));
				functions(T.pop(), T, E);
				break;
			case 5:
			case 6: return false;
		}
		return true;
	}


	private static Double apply(double b, Character pop, double a) {
		switch (pop) {
			case MINUS: return b - a;
			case PLUS: return b + a;
			case DIVISION: return b / a;
			case TIMES: return b * a;
		}
		return 0d;
    }

	private static int operationCode (char c) {
		switch (c) {
			case LEFT_PAREN: return 1;
			case PLUS: return 2;
			case MINUS: return 3;
			case TIMES: return 4;
			case DIVISION: return 5;
			case RIGHT_PAREN: return 6;
			default: return 0;
		}
	}

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        try (BufferedReader lineReader = new BufferedReader(new InputStreamReader(System.in))) {
            String sequence;
            while (!QUIT.equals(sequence = lineReader.readLine())) {
                System.out.println(evaluate(sequence.split(" ")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}