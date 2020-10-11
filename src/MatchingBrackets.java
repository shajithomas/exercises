/*
Determine whether a given string of parentheses (multiple types) is properly nested.

A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

S is empty;
S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.
For example, the string "{[()()]}" is properly nested but "([)()]" is not.

Write a function:

class Solution { public int solution(String S); }

that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..200,000];
string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".

 */

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class MatchingBrackets {
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

    public int matchingBrackets(String S) {
        Deque<Character> s = new ArrayDeque<>();
        char[] in = S.toCharArray();
        for (int i = 0; i < in.length; i++) {
            if (isLeftBrace(new Character(in[i]))) {
                s.offerFirst(in[i]);
            } else if (isRightBrace(in[i])) {
                Character leftBrace = s.pollFirst();
                if (leftBrace == null) {
                    return 0;
                }
                if (match(leftBrace, in[i])) {
                    continue;
                } else {
                    return 0;
                }
            }
        }
        return 1;
    }

    public int matchingBrackets2(String S) {
        MyStack s = new MyStack();
        char[] in = S.toCharArray();
        for (int i = 0; i < in.length; i++) {
            if (isLeftBrace((in[i]))) {
                s.push(in[i]);
            } else if (isRightBrace(in[i])) {
                char leftBrace = s.pop();
                if (leftBrace == '#') {
                    return 0;
                }
                if (match(leftBrace, in[i])) {
                    continue;
                } else {
                    return 0;
                }
            }
        }
        return 1;
    }

    boolean isLeftBrace(Character c) {
        return c == '(' || c == '{' || c == '[';
    }

    boolean isRightBrace(Character c) {
        return c == ')' || c == '}' || c == ']';
    }

    boolean match(char l, char r) {

        switch (l) {
            case '(':
                return (r == ')');
            case '[':
                return (r == ']');
            case '{':
                return (r == '}');
            default:
                return false;
        }
    }

    public class MyStack {
        char[] data = new char[200000];
        int pos = 0;
        public void push(char c) {
            data[pos++] = c;
        }
        public char pop() {
            if (pos <= 0) {
                return '#';
            }
            return data[--pos];
        }
    }
}
