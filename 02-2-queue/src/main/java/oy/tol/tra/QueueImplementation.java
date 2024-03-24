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
        if (tail + 1 > capacity) {
            try {
                capacity = capacity + 10;
                Object[] newItemArray = new Object[capacity];
                for (int i = 0; i < size; i++) {
                    newItemArray[i] = itemArray[head + i];
                }
                itemArray = newItemArray;
                head = 0;
                tail = size;
            } catch (Exception e) {
                throw new QueueAllocationException("No room for queue.");
            }
        }
        itemArray[tail] = element;
        tail++;
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
        head++;
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
        for (int i = 0; i < size; i++) {
            sb.append(itemArray[head + i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}