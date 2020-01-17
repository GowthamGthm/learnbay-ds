import java.util.Stack;

public class SortStack {


    public static void main(String[] args)
    {

        Stack<Integer> stack=new Stack<>();
        stack.push(7);
        stack.push(6);
        stack.push(2);
        stack.push(90);
        stack.push(10);
        stack.push(80);
        sortWithoutExtraSpace(stack);
        System.out.println(stack);
        Stack<Integer> stackResult=new Stack<>();
        sortUsingTwoNewStack(stack,stackResult,new Stack<>(),-1);

        System.out.println(stackResult);

    }


    static void sortUsingTwoNewStack(Stack<Integer> originalStack, Stack<Integer> resultStack, Stack<Integer> midStack, int min) {
        if (originalStack.isEmpty()) {
            resultStack.push(min);
            min = -1;
            if(!midStack.isEmpty()) {
                sortUsingTwoNewStack(midStack, resultStack, originalStack, min);
            }
            return;
        }

        int pop = originalStack.pop();
        if (min > pop || min == -1) {
            int temp = min;
            min = pop;
            pop = temp;
        }
        if (pop != -1) {
            midStack.push(pop);
        }
        sortUsingTwoNewStack(originalStack,resultStack, midStack, min);

    }
    static void sortWithoutExtraSpace(Stack<Integer> originalStack) {
        if (originalStack.isEmpty()) {
            return;
        }
        int pop = originalStack.pop();
        sortWithoutExtraSpace(originalStack);
        insertElement(originalStack,pop);

    }

    private static void insertElement(Stack<Integer> originalStack, int insertElement) {
        if(originalStack.isEmpty()||originalStack.peek()<insertElement)
        {
            originalStack.push(insertElement);
            return;
        }
        int pop=originalStack.pop();
        insertElement(originalStack,insertElement);
        originalStack.push(pop);

    }
}
