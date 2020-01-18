
/*Reverse a Stack using Recursion
Time Complexity-O(n^2)
 */


import java.util.Stack;

public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.push(7);
        stack.push(6);
        stack.push(2);
        stack.push(90);
        stack.push(10);
        stack.push(80);
        System.out.println(stack);
        reverseStackUsingRecursion(stack);
        System.out.println("Reverse"+stack);
    }

    static void reverseStackUsingRecursion(Stack<Integer> stack) {

        if (stack.isEmpty()) {
            return;
        }
        int top = stack.pop();
        reverseStackUsingRecursion(stack);
        insertElement(stack, top);


    }

    private static void insertElement(Stack<Integer> stack, int element) {
        if (stack.isEmpty()) {
            stack.push(element);
            return;
        }

        int top = stack.pop();
        insertElement(stack, element);
        stack.push(top);
    }
}

