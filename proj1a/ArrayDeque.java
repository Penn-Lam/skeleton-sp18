public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int head;
    private int tail;
    private static final int RFACTOR = 8;

    public ArrayDeque() {
        items = (T[]) new Object[RFACTOR];
        size = 0;
        head = 0;
        tail = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(T item) {
        if (size == items.length * 4) {
            resize(size);
        }
        head = (head - 1 + items.length) % items.length;
        items[head] = item;
        size++;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(items.length * 4);
        }
        tail = (tail + 1 + items.length) % items.length;
        items[tail] = item;
        size++;
    }

    private void resize(int newsize) {
        T[] a = (T[]) new Object[newsize];

        for (int i = 0; i < size; i++) {
            a[i] = items[(i + head) % items.length];
        }

        items = a;
        head = 0;
        tail = size;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        } else {
            T item = items[head];
            items[head] = null;
            return item;
        }
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            T item = items[tail];
            items[tail] = null;
            return item;
        }
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.println(items[(i + head) % items.length] + " ");
        }
    }

    public T get(int index) {
        return items[(index + head) % items.length];
    }

}
