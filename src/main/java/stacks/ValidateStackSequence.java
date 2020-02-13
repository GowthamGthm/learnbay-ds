import java.util.Stack;

public class ValidateStackSequence {

        public static boolean validateStackSequences(int[] pushed, int[] popped) {

            Stack<Integer> stack=new Stack<>();
            int j=0;
            for(int i=0;i<pushed.length;i++)
            {
                stack.push(pushed[i]);
                while(!stack.isEmpty() && stack.peek()==popped[j])
                {
                    stack.pop();
                    j++;

                }

            }

            return j==pushed.length;
        }

    public static void main(String[] args) {
        int[] pushed=new int[]{1,2,3,4,5};
        int[] popped=new int[]{4,5,3,2,1};

        System.out.println(validateStackSequences(pushed,popped));
    }
}
