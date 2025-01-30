public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int head;
    private int tail;
    private static final int INITIAL_SIZE = 8;

    public ArrayDeque() {
        items = (T[]) new Object[INITIAL_SIZE];
        size = 0;
        head = 0;
        tail = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize(items.length * 2);
        }
        if (isEmpty()) {
            head = tail = 0;
        } else {
            head = (head - 1 + items.length) % items.length;
        }
        items[head] = item;
        size++;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(items.length * 2);
        }
        if (isEmpty()) {
            head = tail = 0;
        } else {
            tail = (tail + 1) % items.length;
        }
        items[tail] = item;
        size++;
    }

    private void resize(int newsize) {
        newsize = Math.max(INITIAL_SIZE, newsize);
        T[] newItems = (T[]) new Object[newsize];
        if (size > 0) {
            int current = head;
            for (int i = 0; i < size; i++) {
                newItems[i] = items[current];
                current = (current + 1) % items.length;
            }
        }
        items = newItems;
        head = 0;
        tail = Math.max(0, size - 1);
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T item = items[head];
        items[head] = null;
        size--;
        if (size == 0) {
            head = tail = 0;
        } else {
            head = (head + 1) % items.length;
            if (items.length > INITIAL_SIZE && size < items.length / 4) {
                resize(items.length / 2);
            }
        }
        return item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T item = items[tail];
        items[tail] = null;
        size--;
        if (size == 0) {
            head = tail = 0;
        } else {
            tail = (tail - 1 + items.length) % items.length;
            if (items.length > INITIAL_SIZE && size < items.length / 4) {
                resize(items.length / 2);
            }
        }
        return item;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return items[(head + index) % items.length];
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[(head + i) % items.length]);
            if (i < size - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
