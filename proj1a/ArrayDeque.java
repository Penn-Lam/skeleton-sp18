public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int head;
    private int tail;
    private static final int RFACTOR = 8;

    public ArrayDeque() {
        items = (T[]) new Object[8];
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
        if (size == items.length) {
            resize(items.length * 2);
        }
        if (!isEmpty()) {
            head = (head - 1 + items.length) % items.length;
        }
        items[head] = item;
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(items.length * 2);
        }
        items[tail] = item;
        size++;
        if (size == 1) {
            head = tail = 0;
        } else {
            tail = (tail + 1) % items.length;
        }
    }

    private void resize(int newsize) {
        T[] a = (T[]) new Object[newsize];
        if (size > 0) {
            if (head <= tail) {
                System.arraycopy(items, head, a, 0, size);
            } else {
                System.arraycopy(items, head, a, 0, items.length - head);
                System.arraycopy(items, 0, a, items.length - head, tail + 1);
            }
        }
        items = a;
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
        }
        if (items.length >= 16 && size < items.length / 4) {
            resize(items.length / 2);
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
        }
        if (items.length >= 16 && size < items.length / 4) {
            resize(items.length / 2);
        }
        return item;
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
