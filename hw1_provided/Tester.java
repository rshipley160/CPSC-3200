public class Tester {


    public static void main(String[] args) 
    {
        // See  the SinglyLinkedList class in action ...
        SinglyLinkedList<String> sl1 = new SinglyLinkedList<>();

        sl1.add("a");
        sl1.add("b");
        sl1.add("c");

        sl1.add(1, "in the middle!");
        sl1.add(0, "at the beginning");

        System.out.println("List contents:");
        for (String s : sl1)
        {
            System.out.println(s);
        }

        // // Equivalent code using an explicit iterator
        //
        // java.util.Iterator<String> it = sl1.iterator();
        // while (it.hasNext())
        // {
        //     System.out.println(it.next());
        // }
            
        // // Somewhat equivalent code using the get() method
        //
        // for (int i=0; i<sl1.size(); i++)
        // {
        //     System.out.println(sl1.get(i));
        // }


        // Analyze the performance of the .add() method

        System.out.println();
        System.out.println("now some timing tests...");
        System.out.println();
        
        for (long N=10000; N<100000; N*=2)
        {
            long start = System.nanoTime();
            addN(N);
            long end = System.nanoTime();

            System.out.println("calling add() " + N + " times took " + (end-start)/1e6 + " ms");
        }

    }


    public static SinglyLinkedList<Long> addN(long N)
    {
        SinglyLinkedList<Long> slist = new SinglyLinkedList<>();

        for (long i=0; i<N; i++)
        {
            slist.add(i);
        }

        return slist;
    }


}
