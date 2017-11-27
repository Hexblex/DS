package list;

import com.google.common.base.Preconditions;

class LinkedList<T>
{
    private Node<T> head;

    Node<T> getHead()
    {
        return this.head;
    }

    void add(T val, int pos) throws Exception
    {
        Preconditions.checkArgument(pos >= 0, "Position must be greater than or equal to 0");

        Node<T> curr = this.head;
        Node<T> prev = null;
        while(curr != null && pos > 0)
        {
            prev = curr;
            curr = curr.next;
            --pos;
        }

        if(pos > 0)
        {
            throw new Exception("Cannot insert beyond length of existing linked list");
        }

        if(prev == null)
        {
            this.head = new Node<>(val);
        }
        else
        {
            Node<T> nodeToAdd = new Node<>(val);
            Node<T> temp = prev.next;
            prev.next = nodeToAdd;
            nodeToAdd.next = curr;
        }
    }

    boolean contains(final T val)
    {
        Node<T> curr = this.head;

        while(curr != null)
        {
            if(curr.val.equals(val))
            {
                return true;
            }

            curr = curr.next;
        }

        return false;
    }

    void addToHead(T val) throws Exception
    {
        Node<T> newNodeToAdd = new Node<>(val);
        newNodeToAdd.next = this.head;
        this.head = newNodeToAdd;
    }

    void removeFirst()
    {
        this.head = this.head.next;
    }

    void remove(T val)
    {
        Node<T> curr = this.head;
        Node<T> prev = null;

        while(curr != null && curr.val != val)
        {
            prev = curr;
            curr = curr.next;
        }

        if(curr != null)
        {
            if(prev == null)
            {
                this.head = this.head.next;
            }
            else
            {
                prev.next = curr.next;
                curr.next = null;
            }
        }
    }


    static class Node<T>
    {
       private T val;
       private Node<T> next;

       private Node(T val)
       {
           this.val = val;
       }

       public T getVal()
       {
           return this.val;
       }

       public Node<T> getNext()
       {
           return this.next;
       }
    }
}
