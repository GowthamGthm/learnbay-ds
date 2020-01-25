public class ReverseEvenNode {

  public static void main(String[] args) {
    Node node=new Node(1);
   Node a= node.next=new Node(2);
    Node b= a.next=new Node(3);
    Node c= b.next=new Node(4);
    Node d= c.next=new Node(5);

    oddEvenList(node);

    System.out.println("node");
  }

  public static Node oddEvenList(Node head) {

    Node odd = head;
    Node even = head.next;
    Node evenHead = head.next;

    while (odd != null && even != null) {
      odd.next = even.next;
      even.next = odd.next;
      odd = odd.next;
      even = even.next;
    }

    reverse(evenHead);
    odd=head;
    even=evenHead;
    head.next = evenHead;
    head = head.next;
    while (odd != null && even != null) {
      head.next = odd.next;
      head = head.next;
      head.next = even.next;
      head = head.next;
      odd = odd.next;
      even = even.next;
    }
    if (odd != null) {
      head.next = odd;
    } else if (even != null) {
      head.next = even;
    }
    return head;
  }

    private static Node reverse(Node head)
    {
      if(head.next==null)
      {
        return head;
      }
      Node end=reverse(head.next);
      head.next.next=head;
      head.next=null;
      return end;
    }
  }

 class Node {
  int val;
  Node next;
  Node(int x) { val = x; }
}
