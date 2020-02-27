
/*
 Insert at Begining
    2. Insert at End
    3. Search by Value
    4. Search By Index
    5. Delete by Value
    6. Delete By Index.
    7. Sort
    8. Reverse using recursion
    9. Reverse using iteration.
    10. Size of linkedList.
*/

import java.util.Comparator;

public class LinkedListOperations<E extends Comparable<E>> {

    private Node<E> head = null;

    private static class Node <E>{
        E value;
        Node<E> next;

        Node(E value) {
            this.value = value;
            this.next = null;
        }
    }

    void insertAtBegining(E value) throws Exception {
        Node<E> insertNode = new Node<>(value);
        if (this.head == null) {
            head = insertNode;
            return;
        }

        insertNode.next = this.head;
        head = insertNode;
    }

    void insertAtEnd(E value) {
        Node<E> insertNode = new Node<>(value);
        if (this.head == null) {
            head = insertNode;
            return;
        }
        Node<E> temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = insertNode;
    }

    boolean searchByValue(E value) {
        Node<E> temp = this.head;

        while (temp != null) {
            if (temp.value.compareTo(value) == 0)
                return true;
            temp=temp.next;
        }
        return false;
    }

    E searchByIndex(int index) {
        Node<E> temp = this.head;
        int ptr = 1;
        while (ptr < index && temp.next != null) {
            temp = temp.next;
            ptr++;

        }

        if (ptr == index) {
            return temp.value;

        }
        return null;
    }

    private boolean deleteByIndex(int index) {

      // check for first element deletion
      if(index==1&&head!=null)
      {
        head=head.next;
        return true;
      }

        Node<E> temp = this.head;
        int ptr = 1;


        while (temp.next != null && ptr < index - 1) {
            temp = temp.next;
            ptr++;
        }

        if (ptr == index - 1 && temp.next != null) {
            temp.next = temp.next.next;
            return true;
        }
        return false;

    }

    private boolean deleteByValue(E value) {


      // check for first element
      if (head.value.compareTo(value) == 0 && head != null) {
        head = head.next;
        return true;
      }
      Node<E> temp = this.head;
      while (temp.next != null) {
        if (temp.next.value.compareTo(value) == 0) {
          temp.next = temp.next.next;
          return true;
        }
        temp = temp.next;
      }


      return false;

    }

  private int size() {

    Node<E> temp = this.head;
    int size = 0;
    while (temp != null) {
      temp = temp.next;
      size++;
        }
        return size;


    }

    private Node<E> reverse(Node<E> top) {

        if (top == null || top.next == null) {
            return top;
        }

        Node<E> reverseHead = reverse(top.next);
        top.next.next = top;
         top.next = null;
         head=reverseHead;
        return head;


    }

  private void reverseUsingIteration(Node<E> head) {

    if (head == null) {
      return;
    }

    Node<E> nextElement = head.next;
    Node<E> prevElement = head;
    prevElement.next = null;
    while (nextElement != null) {

      Node<E> temp = nextElement.next;
      nextElement.next = prevElement;
      prevElement = nextElement;
      nextElement = temp;


    }
    this.head=prevElement;
  }

    private void sort()
    {
      sort(head,head);
    }

    private void sort(Node<E> head, Node<E> originalHead) {


        if (head.next == null) {
            return;
        }


        if (head.value.compareTo(head.next.value) > 0) {
            E tempValue = head.value;
            head.value = head.next.value;
            head.next.value = tempValue;
            sort(originalHead, originalHead);

        }
        sort(head.next, originalHead);
    }

    private void print() {
      Node<E> temp=head;
        while (temp != null) {

            System.out.println(temp.value);
            temp=temp.next;
        }
    }

    public static void main(String[] args) throws Exception {
        LinkedListOperations<Integer> l = new LinkedListOperations<>();
        l.insertAtEnd(14);
        l.insertAtBegining(12);
        l.insertAtEnd(10);
        l.insertAtBegining(15);
        l.insertAtEnd(19);
    //   System.out.println(l.deleteByIndex(6));
    //  System.out.println(l.deleteByIndex(3));
    //  System.out.println(l.deleteByValue(15));
      //System.out.println(l.deleteByValue(12));
      /*System.out.println(l.searchByIndex(6));
      System.out.println(l.searchByIndex(1));
      System.out.println(l.searchByValue(100));
      System.out.println(l.searchByValue(12));*/
       l.print();
       System.out.println(" .....");
       l.sort();
       l.print();

    }
}
