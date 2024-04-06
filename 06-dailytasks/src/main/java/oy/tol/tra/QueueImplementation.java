package oy.tol.tra;

public class QueueImplementation<E> implements QueueInterface<E> {
    private Object[] itemArray;
    private int head = 0; // Index of the current front item, if it exists
    private int tail = 0; // Index where the next element will be added
    private int size = 0; // Number of elements in the queue
    private int capacity;
    private static final int DEFAULT_QUEUE_SIZE = 10;

    public QueueImplementation() throws QueueAllocationException {
        this(DEFAULT_QUEUE_SIZE);
    }

    public QueueImplementation(int capacity) throws QueueAllocationException {
        if (capacity < 2) {
            throw new QueueAllocationException("Capacity must be at least 2.");
        }
        this.capacity = capacity;
        this.itemArray = new Object[capacity];
    }

    @Override
    public void enqueue(E element) throws QueueAllocationException, NullPointerException {
        if (element == null) {
            throw new NullPointerException("Cannot enqueue null element.");
        }
        if (size == capacity) {
            int newCapacity = capacity * 2;
            Object[] newArray = new Object[newCapacity];

            for (int i = 0; i < size; i++) {
                newArray[i] = itemArray[(head + i) % capacity];
            }

            itemArray = newArray;
            capacity = newCapacity;
            head = 0;
            tail = size;
        }

        itemArray[tail] = element;
        tail = (tail + 1) % capacity;
        size++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E dequeue() throws QueueIsEmptyException {
        if (isEmpty()) {
            throw new QueueIsEmptyException("Queue is empty.");
        }
        E element = (E) itemArray[head];
        itemArray[head] = null;
        head = (head + 1) % capacity;
        size--;
        return element;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E element() throws QueueIsEmptyException {
        if (isEmpty()) {
            throw new QueueIsEmptyException("Queue is empty.");
        }
        return (E) itemArray[head];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int capacity() {
        return this.capacity;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            itemArray[head + i] = null;
        }
        size = 0;
        head = 0;
        tail = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int curIdx;
        for (int i = 0; i < size; i++) {
            curIdx = (head + i) % capacity;
            sb.append(itemArray[curIdx]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}