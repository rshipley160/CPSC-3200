/**
   A generic SinglyLinkedList class for you to modify and analyze
*/
public class SinglyLinkedList<T> implements Iterable<T>{

    // since this is an inner class (not a static nested class), we can access
    // T
    private class Node
    {
        T value;
        Node next;

        Node(T value, Node next)
        {
            this.value=value;
            this.next=next;
        }

        Node() { }
    }

    private int count;          // number of items in the list
    private Node head;          // pointer to dummy node at head of list
    private Node tail;          // pointer to last node in the list, initially the head node
    
    public SinglyLinkedList()
    {
        head = new Node();      // dummy node
        tail = head;
    }


    /**
     * Add a value to the end of the list
     * @param value the value to be added
     * Performs in about the same time no matter the length of the list
    */
    void add(T value)
    {
        Node added  = new Node(value,null); 
        tail.next   = added;
        tail        = added;
        count++;
    }
    
    /**
     * Add a value to the list at position index
     * @param index the desired location
     * @param value the value to be added
     *
     * Note: this throws an exception if index is invalid
     *
     * Food for thought:  How does the performance of this method depend on index?
     */
    void add(int index, T value)
    {
        Node c=findNode(index);
        c.next=new Node(value, c.next);
        count++;
    }


    /**
       @index the index of the desired list value
       @return the value in the list at the index'th position

       Throws exception if index is invalid
    */
    T get(int index)
    {
        Node c=findNode(index);
        return c.next.value;
    }
    

    /**
     * @return the number of items in this list
     */
    int size()
    {
        return count;
    }
    

    /**
     * Returns a Node whose .next member is (or would be, in the case of
     * index==count) the index'th Node in the list
     *
     * Throws an exception if the index is not valid
     *
     * @param index the index of the desired Node
     * @return the Node whose next is the index'th
     */
    private Node findNode(int index)
    {
        // Notice how the use of a 'dummy' node at the head makes this logic
        // simpler

        Node curs=head;
        int p=0;

        if (index < 0)
        {
            throw new RuntimeException("invalid index: " + index);
        }

        while (p<index && curs != null)
        {
            curs=curs.next;
            p++;
        }

        if (curs == null)
        {
            throw new RuntimeException("invalid index: " + index);
        }

        return curs;
    }
        

    


    /**
       Implements java.lang.Iterable<T>
    */
    public java.util.Iterator<T> iterator()
    {
        return new ForwardIterator();
    }


    private class ForwardIterator implements java.util.Iterator<T>
    {
        // This is legal since it's a proper inner class (not a static nested
        // class)
        Node curs=head;

        public boolean hasNext()
        {
            return curs.next != null;
        }

        // Note: this method has undefined behavior if hasNext() return false
        public T next()
        {
            curs=curs.next;
            return curs.value;
        }

        // TODO:  add a remove() method -- see the java.util.Iterator documentation

    }


    // TODO: Write a ReverseIterator inner class, along with a public method
    // for returning it.  Normally you would only have such a thing on a
    // doubly linked list, but we're writing one to analyze its performance.


}
