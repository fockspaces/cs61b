package deque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayDeque<T> implements Deque<T>, Iterable<T>{
    private int INIT_SIZE = 4;
    private int front;
    private int back;
    private int size;
    private T[] items;

    @SuppressWarnings("unchecked")
    public ArrayDeque(){
        items = (T[]) new Object[INIT_SIZE];
        front = items.length - 1;
        back = 0;
        size = 0;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newSize) {
        T[] resizedArray = (T[]) new Object[newSize];
        if (front < back) {
            // The deque does not wrap around the end of the array.
            System.arraycopy(items, front + 1, resizedArray, 0, size);
        } else {
            // The deque wraps around the end of the array.
            int firstHalfLength = items.length - (front + 1);
            int secondHalfLength = back;

            System.arraycopy(items, front + 1, resizedArray, 0, firstHalfLength);
            System.arraycopy(items, 0, resizedArray, firstHalfLength, secondHalfLength);
        }

        items = resizedArray;
        front = newSize - 1; // Reset front to just before the first element
        back = size; // Back is set to the index where the next element will be added
    }


    @Override
    public void addFirst(T item){
        items[front] = item;
        size++;
        front = (front - 1 + items.length) % items.length;
        if(front == back){
            resize(2 * items.length);
        }
    }

    @Override
    public void addLast(T item){
        items[back] = item;
        size++;
        back = (back + 1) % items.length;
        if(back == front){
            resize(2 * items.length);
        }
    }

    @Override
    public boolean isEmpty(){
        return this.size() == 0;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public void printDeque(){
        for(int i = front; i < front + this.size(); i++) {
            System.out.print(items[i % items.length]);
            System.out.print(" ");
        }
        System.out.println();
    }

    @Override
    public T removeFirst(){
        int newFront = (front + 1) % items.length;
        if(newFront == back) {
            return null;
        }
        front = newFront;
        T deleteData = items[front];
        size--;
        if(size < items.length / 4){
            resize(items.length / 2);
        }
        return deleteData;
    }

    @Override
    public T removeLast(){
        int newBack = (back - 1 + items.length) % items.length;
        if(newBack == front) {
            return null;
        }
        back = newBack;
        T deleteData = items[back];
        size--;
        if(size < items.length / 4){
            resize(items.length / 2);
        }
        return deleteData;
    }

    @Override
    public T get(int index){
        if(index >= this.size()){
            return null;
        }
        return items[(front + 1 + index) % items.length];
    }

    @Override
    public Iterator<T> iterator(){
        return null;
    }

    @Override
    public boolean equals(Object o){
        return false;
    }
}