package stack;

interface IStack<T>
{
    T pop();
    void push(T val);
    T peek();
}
