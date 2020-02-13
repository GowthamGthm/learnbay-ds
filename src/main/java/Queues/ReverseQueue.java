
import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> queue=new LinkedList<Integer>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        System.out.println(queue);
        reverseQueue(queue);
        System.out.println(queue);
    }

    private static Queue<Integer> reverseQueue(Queue<Integer> queue) {
        if(queue.size()<=1)
        {
            return queue;
        }
        int poll=queue.poll();
        Queue<Integer> reversedQueue=reverseQueue(queue);
        reversedQueue.add(poll);

        return queue;
    }
}
