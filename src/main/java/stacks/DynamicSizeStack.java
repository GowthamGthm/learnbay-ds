public class DynamicSizeStack<E> implements IStack<E> {
    private E[] array;
    private float loadFactor=0.75f;
    private int threshold;
    private int top=-1;

    @SuppressWarnings("unchecked")
    DynamicSizeStack(int initialSize)
    {
        array=(E[])new Object[initialSize];
        threshold= (int) (initialSize*loadFactor);
    }

    @Override
    public void push(E element) throws Exception {
            if(isFull())
            {
                throw new Exception("Stack overflow Exception");
            }
            array[++top]=element;
    }

    @Override
    public E pop() {
        if(isEmpty()) return null;
        return array[top--];
    }

    @Override
    public E peek() {
        return array[top];
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
