package _20221130;

import java.util.Comparator;
import java.util.Stack;

public class SpecialStack {
    private int min = Integer.MAX_VALUE;
    private final Stack<Integer> stack = new Stack<>();

    public void push(int e) {
        min = Math.min(e, min);
        stack.push(e);
    }

    public int pop() {
        int e = stack.pop();
        if (e == min) {
            min = stack.stream().min(Comparator.naturalOrder()).get();
        }
        return e;
    }

    public int peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.empty();
    }

    public int size() {
        return stack.size();
    }

    public int getMin() {
        return min;
    }

}