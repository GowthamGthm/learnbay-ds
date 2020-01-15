public interface IStack<E> {

    public void push(E element) throws Exception;

    public E pop();

    public E peek();

    public boolean isEmpty();

    public boolean isFull();

    public void print();
}
