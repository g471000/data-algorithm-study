package ch_03_stack_and_queue.q03_multi_stack;

import java.util.EmptyStackException;

public class Stack {
    private int capacity;
    public int size = 0;
    private int[] stack;

    public Stack(int capacity){
        stack = new int[capacity];
        this.capacity = capacity;
    }

    public boolean isFull() {
        return capacity == size;
    }

    public boolean push(int value) {
        if (size >= capacity) {
            return false;
        }
        stack[size++] = value;
        return true;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        int value = stack[size - 1];
        size--;
        return value;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(stack[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
