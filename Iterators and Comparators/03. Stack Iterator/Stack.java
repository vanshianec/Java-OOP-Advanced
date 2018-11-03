import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<T> implements Iterable<T> {

    private static final int INITIAL_CAPACITY = 16;
    private int count;
    private T[] stack;

    @SuppressWarnings("unchecked")
    public Stack() {
        this.stack = (T[]) new Object[INITIAL_CAPACITY];
        this.count = 0;
    }

    @SuppressWarnings("unchecked")
    public Stack(int capacity) {
        this.stack = (T[]) new Object[capacity];
        this.count = 0;
    }

    private void grow() {
        this.stack = Arrays.copyOf(this.stack, this.stack.length * 2);
    }

    public void push(T element) {
        if (count == this.stack.length) {
            grow();
        }
        this.stack[this.count++] = element;
    }

    public T pop() {
        if (count == 0) {
            throw new NoSuchElementException("No elements");
        }
        T element = this.stack[--this.count];
        this.stack[this.count] = null;
        return element;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int counter = count - 1;

            public boolean hasNext() {
                return counter >= 0;
            }

            @Override
            public T next() {
                return stack[counter--];
            }
        };
    }
}
