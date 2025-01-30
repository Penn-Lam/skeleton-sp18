public class LinkedListDeque<T> {
    private T[] elements;
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data){
            this.data = data;
        }
    }

    public LinkedListDeque() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public int size(){
        return size;
    }

    public void addFirst(T item){
        Node<T> newNode = new Node<>(item);
        if(isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size ++;
    }

    public void addLast(T item) {
        Node<T> newNode = new Node<>(item);
        if(isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size ++;
    }

    public T removeFirst() {
        if(isEmpty()) {
            return null;
        }
        T item = head.data;
        if(size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size --;
        return item;
    }

    public T removeLast() {
        if(isEmpty()) {
            return null;
        }
        T item = tail.data;
        if(size == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size --;
        return item;
    }

    public void printDeque() {
        Node<T> p = head;
        while(p != null) {
            System.out.println(p.data + " ");
            p = p.next;
        }
    }

    public T get(int index) {
        Node<T> p = head;
        while(index > 0) {
            p = p.next;
            index --;
        }
        return p.data;

    }

    public T getRecursive(int index) {
        return getRecursiveHelper(head, index);
   }

   private T getRecursiveHelper(Node<T> p, int index) {
        if(index == 0) {
            return p.data;
        } else {
            return getRecursiveHelper(p.next, index - 1);
        }
   }

}
