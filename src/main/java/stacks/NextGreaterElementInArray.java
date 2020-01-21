

/*
Next Greater element in an array.
Time- O(n)
Space-O(n)
*/

import java.util.Stack;

public class NextGreaterElementInArray {

    public static void main(String[] args) {
        int[] a=new int[]{90, 11, 13, 21, 3 ,42, 5};
        int n=a.length;
        printNextGreaterElementInArray(a,n);
    }

   /*90, 11, 13, 21, 3 42, 5*/
    private static void printNextGreaterElementInArray(int[] a, int n) {
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++)
        {
            while (!stack.isEmpty()&&a[i] > stack.peek()) {
                System.out.println(stack.pop() + "->" + a[i]);
            }
                stack.push(a[i]);
        }
        while(!stack.isEmpty())
        {
            System.out.println(stack.pop() +"->-1");
        }
    }
}
