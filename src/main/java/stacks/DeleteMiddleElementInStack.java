import java.util.Stack;

public class DeleteMiddleElementInStack {

  private static void deleteMiddleElementFromStackWhenStackSizeIsKnown(Stack<Integer> stack, int n,
      int cur) {
    if (stack.isEmpty() || cur == n/2+1) {
      return;
    }

    int top = stack.pop();
    deleteMiddleElementFromStackWhenStackSizeIsKnown(stack, n, cur + 1);

    if (cur !=n/2) {
      stack.push(top);
    }
  }

  private static void deleteMiddleElementFromStackWithoutUsingSizeMethod(Stack<Integer> stack) {

    if (stack.isEmpty()) {
      if(size%2!=0) size++;
      return;
    }

    int top=stack.pop();
    size++;
    deleteMiddleElementFromStackWithoutUsingSizeMethod(stack);
    if(++curr!=size/2) {
      stack.push(top);
    }
  }

  private static int size=0;
  private static int curr=0;

  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.push(2);
    stack.push(6);
    stack.push(7);
    stack.push(9);
    stack.push(10);
    stack.push(12);
    stack.push(13);
    stack.push(15);

    deleteMiddleElementFromStackWhenStackSizeIsKnown(stack, stack.size(), 0);
    System.out.println(stack);
    deleteMiddleElementFromStackWithoutUsingSizeMethod(stack);
    System.out.println(stack);
  }
}
