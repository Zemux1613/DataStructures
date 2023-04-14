package stack;

import java.lang.reflect.Array;

public class Stack<T> {

    private final int capacity;
    private T[] items;
    private int size;

    public Stack(int capacity) {
        this.capacity = capacity;
    }

    public void push(T value) {
        if (this.items == null) {
            this.items = (T[]) Array.newInstance(value.getClass(), capacity);
        }
        if (this.size + 1 <= this.capacity) {
            this.items[this.size] = value;
            this.size++;
        }
    }

    public T pop() {
        if (this.size != 0) {
            T item = this.items[this.size];
            this.items[this.size] = null;
            this.size--;
            return item;
        }
        return null;
    }
}
