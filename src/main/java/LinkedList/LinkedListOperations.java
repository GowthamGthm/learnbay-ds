
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

public class LinkedListOperations<E> {

  private Node<E> head=null;
  static class Node<E>{
    E value;
    Node next;

    Node(E value)
    {
      this.value=value;
      this.next=null;
    }
  }

  void insertAtBegining(E value) throws Exception
  {
    Node<E> insertNode=new Node<>(value);
    if(this.head==null)
    {
      head=insertNode;
      return;
    }

    insertNode.next=this.head;
    head=insertNode;
  }

  void insertAtEnd(E value)
  {
    Node<E> insertNode=new Node<>(value);
    if(this.head==null)
    {
      head=insertNode;
      return;
    }
    Node temp=this.head;
    while(temp.next!=null)
    {
      temp=temp.next;
    }

    temp.next=insertNode;
  }

  boolean searchByValue(E value)
  {
    Node temp=this.head;

    while(temp.next!=null)
    {
      if(temp.value==value)
        return true;
    }
    return false;
  }

  boolean searchByIndex(int index)
  {
    Node temp=this.head;
    int ptr=0;
    while(ptr<index&&temp.next!=null)
    {
      temp=temp.next;
      ptr++;

    }

    if(ptr==index)
    {

    }
    return false;
  }
}
