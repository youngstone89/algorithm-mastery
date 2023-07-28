import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        val = Math.min(val, minStack.isEmpty() ? val : minStack.peek());
        minStack.push(val);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack m = new MinStack();
        m.push(-1);
        System.out.println(m.getMin());
        m.push(-2);
        System.out.println(m.getMin());
        m.push(-3);
        System.out.println(m.getMin());
        m.pop();
        m.top();
        System.out.println(m.getMin());
    }
}
