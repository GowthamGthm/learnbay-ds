
/*Postfix Evaluation using Stack*/

import java.util.Stack;

public class PostfixEvaluationUsingStack {

  public static void main(String[] args) {
    evaluatePostfixExpressionUsingStack("2 3 1 * + 9 -");
    evaluatePostfixExpressionUsingStack("5 10 2 * + 3 -");
  }

  private static void evaluatePostfixExpressionUsingStack(String postFixExp) {

    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < postFixExp.length(); i++) {
      char ch = postFixExp.charAt(i);
      if (ch == ' ') {
        continue;
      }

      if (Character.isDigit(ch)) {
        int no = ch - '0';
        int j = 10;
        while (Character.isDigit(postFixExp.charAt(++i))) {
          no = (postFixExp.charAt(i) - '0') + no * j;
          j *= 10;
        }

        stack.push(no);
      } else {
        int a = stack.pop();
        int b = stack.pop();

        switch (ch) {
          case '+':
            stack.push(a + b);
            break;
          case '-':
            stack.push(b - a);
            break;
          case '*':
            stack.push(a * b);
            break;
          case '/':
            stack.push(a / b);
            break;
        }
      }
    }
    System.out.println(stack.peek());
  }
}
