package queue;

public interface IQueue<T>
{
    void enqueue(T val);
    T dequeue();
}
