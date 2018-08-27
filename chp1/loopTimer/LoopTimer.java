public class LoopTimer {
    public static void main(String[] args) 
    {
        double last=1;
        // for (long N=100000; N<1e12; N*=2)
        // {
        //     double t = timeLinear(N);
        //     System.out.println(N + " - " + t + " ms - x" + t/last);
        //     last=t;
        // }

        last=1;
        for (long N=10000; N<400000; N*=2)
        {
            double t = timeQuadratic(N);
            System.out.println(N + " - " + t + " ms - x" + t/last);
            last=t;
        }

    }


    public static double timeLinear(long N)
    {
        long start=System.nanoTime();

        int sum=0;
        for (long i = 0; i < N; i++)
        {
            sum++;
        }

        long end=System.nanoTime();

        return (end-start)/1e6;
        

    }

    public static double timeQuadratic(long N)
    {
        long start=System.nanoTime();

        int sum=0;
        for (long i = 0; i < N; i++)
        {
            for (long k = 0; k < N; k++)
            {
                sum++;
            }
            
        }

        long end=System.nanoTime();

        return (end-start)/1e6;
        

    }
    
}
