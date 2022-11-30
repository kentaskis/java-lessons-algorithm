package _20221130;

public class Runner {
    public static void main(String[] args) {
        SpecialStack stack = new SpecialStack();

        stack.push(5);
        stack.push(2);
        stack.push(6);
        stack.push(3);
        stack.push(1);

        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.getMin());
        System.out.println(stack.peek());
    }
}