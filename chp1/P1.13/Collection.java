// simple implementation of Problem 1.13
// You should be able to read and understand this code.  Can you `javadoc' it?

public class Collection<T> {

    private static final int MAX_SIZE=100;


    public Collection()
    {
        this.values = new Object[MAX_SIZE];
        this.count = 0;
    }


    public boolean isEmpty()
    {
        return count == 0;
    }

    public void makeEmpty()
    {
        count = 0;
    }

    public void insert(T value)
    {
        if (count < MAX_SIZE)
        {
            values[count]=value;
            count++;
        }
        else
        {
            throw new RuntimeException("cannot exceed maximum Collection size");
        }
        
    }

    public void remove(T value)
    {
        int i=0;

        while (i < count && ! values[i].equals(value))
        {
            i++;
        }

        if (i == count)
        {
            throw new RuntimeException("value not found in Collection: " + value);
        }

        if (i < count-1)
        {
            values[i] = values[count-1];
        }

        count--;
        
        
    }

    public boolean isPresent(T value)
    {
        for (int i=0; i<count; i++)
        {
            if (values[i].equals(value))
            {
                return true;
            }
        }

        return false;
    }


    private Object[] values;
    private int count;
    

}
