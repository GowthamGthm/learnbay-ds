import java.util.Stack;

public class StackTest {

    public static void main(String[] args) throws Exception {
        DynamicSizeStack<Integer> stack= new DynamicSizeStack<>(5);
        stack.push(2);
        stack.push(6);
        stack.push(7);
        stack.push(9);
        stack.push(10);
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());

    }
}
