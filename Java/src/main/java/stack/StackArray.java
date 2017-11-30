package stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class StackArray<T> implements IStack<T>
{
    private List<T> store = new ArrayList<>();

    private int head = 0, tail = 0;

    @Override
    public T pop()
    {
        if(this.store.isEmpty())
        {
            throw new EmptyStackException();
        }

        T result = this.store.get(this.store.size() - 1);
        this.store.remove(this.store.size()-1);

        return result;
    }

    @Override
    public void push(T val)
    {
        this.store.add(val);
    }

    @Override
    public T peek()
    {
        return this.store.get(this.store.size() - 1);
    }
}
