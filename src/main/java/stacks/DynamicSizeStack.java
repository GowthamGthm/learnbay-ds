public class DynamicSizeStack<E> implements IStack<E> {
    private E[] array;
    private float loadFactor=0.75f;
    private int threshold;
    private int top=-1;
    private int size;

    @SuppressWarnings("unchecked")
    DynamicSizeStack(int initialSize)
    {
        array=(E[])new Object[initialSize];
        size=initialSize;
        threshold= (int) (size*loadFactor);
    }

    @Override
    public void push(E element) throws Exception {
            if(isFull())
            {
               resize();
            }
            array[++top]=element;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        // double the size
        size=size*2;
        E[] newArray = (E[]) new Object[size];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array=newArray;
        threshold=(int) (size*loadFactor);
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
        if (top == -1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isFull() {

        if (top == size-1) {
            return true;
        }
        return false;
    }

    @Override
    public void print() {
            for(int i=top
                ;i>=0;i--)
            {
                System.out.println(array[i]);
            }
    }
}
