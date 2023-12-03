package deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T>{
    private Node<T> sentinel;
    private int size;
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data, Node<T> next, Node<T> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    public LinkedListDeque() {
        sentinel = new Node<T>(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        Node<T> newNode = new Node<T>(item, sentinel.next, sentinel);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size += 1;
    }

    @Override
    public void addLast(T item) {
        Node<T> newNode = new Node<T>(item, sentinel, sentinel.prev);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size += 1;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    };

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void printDeque() {
        Node<T> curNode = sentinel.next;
        for(int i = 0; i < this.size; i++) {
            System.out.print(curNode.data);
            System.out.print(" ");
        }
        System.out.println();
    };

    @Override
    public T removeFirst() {
        if(size == 0) {
            return null;
        }
        T removeData = sentinel.next.data;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return removeData;
    }

    @Override
    public T removeLast() {
        if(size == 0) {
            return null;
        }
        T removeData = sentinel.prev.data;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size -= 1;
        return removeData;
    }

    @Override
    public T get(int index) {
        if(index >= size) {
            return null;
        }
        Node<T> curNode = sentinel.next;
        for(int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        return curNode.data;
    }


    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node<T> current = sentinel.next;

        @Override
        public boolean hasNext() {
            return current != sentinel;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T returnItem = current.data;
            current = current.next;
            return returnItem;
        }
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Deque)) {
            return false;
        }
        Deque<?> otherDeque = (Deque<?>) o;
        if (otherDeque.size() != this.size) {
            return false;
        }

        for (int i = 0; i < this.size; i++) {
            if (!this.get(i).equals(otherDeque.get(i))) {
                return false;
            }
        }
        return true;
    };

    public T getRecursive(int index){
        if(index >= this.size || index < 0) {
            return null;
        }
        return getRecursive(index, sentinel.next);
    }

    private T getRecursive(int index, Node<T> curNode){
        if(index == 0){
            return curNode.data;
        }
        return getRecursive(index - 1, curNode.next);
    }
}