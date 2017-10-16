package seminar1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 1. пустая строка — правильная скобочная последовательность;
 * 2. правильная скобочная последовательность,
 *      взятая в скобки одного типа — правильная скобочная последовательность;
 * 3. правильная скобочная последовательность,
 *      к которой приписана слева или справа правильная скобочная последовательность
 *      — тоже правильная скобочная последовательность.
 */
@SuppressWarnings("Duplicates")
public class ParenthesesSequenceExt {

    private static final String QUIT = "q";

    private static final char LEFT_PAREN     = '(';
    private static final char RIGHT_PAREN    = ')';
    private static final char LEFT_BRACE     = '{';
    private static final char RIGHT_BRACE    = '}';
    private static final char LEFT_BRACKET   = '[';
    private static final char RIGHT_BRACKET  = ']';

    // sequence = "()()" | "(({}[]))[[[" | "{}" | ...
    private static boolean isBalanced(String sequence) {
        /* TODO: implement it */
        char[] seq = sequence.toCharArray();
		Stack<Character> stack = new Stack<>();

        for (char c : seq) {
			if (stack.peek() == antonym(c))
				stack.pop();
			else if (isLeft(c))
				stack.push(c);
			else return false;
        }

        return stack.size() == 0;
    }

	private static boolean isLeft(char c) {
    	return c == LEFT_BRACE || c == LEFT_BRACKET || c == LEFT_PAREN;
	}

	private static Character antonym(char c) {
    	switch (c) {
			case LEFT_BRACE    : return RIGHT_BRACE;
			case LEFT_BRACKET  : return RIGHT_BRACKET;
			case LEFT_PAREN    : return RIGHT_PAREN;

			case RIGHT_BRACE   : return LEFT_BRACE;
			case RIGHT_BRACKET : return LEFT_BRACKET;
			case RIGHT_PAREN   : return LEFT_PAREN;

			default: return null;
		}
	}

	public static void main(String[] args) {
        try (BufferedReader lineReader = new BufferedReader(new InputStreamReader(System.in))) {
            String sequence;
            while (!QUIT.equals(sequence = lineReader.readLine())) {
                System.out.println(isBalanced(sequence) ? "YES" : "NO");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
