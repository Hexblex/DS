package queue;

import org.assertj.core.util.VisibleForTesting;

public class QueueCircularArray<T> implements IQueue<T>
{
    private static int DEFAULT_CAPACITY = 2;

    private T[] store;

    private int head = 0, tail = 0;

    public QueueCircularArray()
    {
        this(DEFAULT_CAPACITY);
    }

    @VisibleForTesting
    QueueCircularArray(int capacity)
    {
        this.store = (T[])new Object[capacity + 1];
    }

    @Override
    public void enqueue(T val)
    {
        int indexToEnqueue = (this.tail + 1) % this.store.length;
        if(indexToEnqueue == this.head)
        {
            throw new QueueFullException();
        }

        this.tail = indexToEnqueue;
        this.store[tail] = val;
    }

    @Override
    public T dequeue()
    {
        if(this.head == this.tail)
        {
            throw new QueueEmptyException();
        }

        ++this.head;
        T result = this.store[this.head];
        this.store[this.head] = null;

        return result;
    }
}
