// RUN THIS WITH ASSERTIONS ENABLED.
// (At the command line, use the -ea flag)

public class CollectionTester {
    public static void main(String[] args) 
    {
        Collection<Integer> coll = new Collection<>();

        // A new Collection should be empty
        assert coll.isEmpty();

        // Add a bunch of values
        for (int i=0; i<100; i++)
        {
            coll.insert(i);
        }

        // A full Collection should *not* be empty
        assert ! coll.isEmpty();

        // We added all of these, so they should be present
        for (int i=0; i<100; i++)
        {
            assert coll.isPresent(i);

            // isPresent should not mutate
            assert coll.isPresent(i);
        }

        // these values should not be present
        assert ! coll.isPresent(-1);
        assert ! coll.isPresent(100);

        // after a remove, 50 should not be present
        coll.remove(50);
        assert ! coll.isPresent(50);
        
        // ... but everything else should be
        for (int i=0; i<50; i++)
        {
            assert coll.isPresent(i);
        }
        for (int i=51; i<100; i++)
        {
            assert coll.isPresent(i);
        }

        // This should be everything...
        for (int i=0; i<100; i++)
        {
            if (coll.isPresent(i))
            {
                coll.remove(i);
            }
        }

        assert coll.isEmpty();

        // Some final tests
        coll.insert(999);
        assert !coll.isEmpty();
        coll.makeEmpty();
        assert  coll.isEmpty();

    }

}
