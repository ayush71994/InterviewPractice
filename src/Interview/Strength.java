package Interview;

public class Strength {

    static int kN = 1000000;

    // Function to return the maximum
    // number of people that can be killed
    static int maxPeople(int p)
    {
        // Storing the sum beforehand so that
        // it can be used in each query
        long []sums = new long[kN];
        sums[0] = 0;
        for (int i = 1; i < kN; i++)
            sums[i] = (long)(i * i) + sums[i - 1];

        // lower_bound returns an iterator pointing to the
        // first element greater than or equal to your val
        int it = lower_bound(sums, 0, kN, p);
        if (sums[it] > p)
        {

            // Previous value
            --it;
        }

        // Returns the index in array upto which
        // killing is possible with strength P
        return it;
    }
    private static int lower_bound(long[] a, int low,
                                   int high, int element)
    {
        while(low < high)
        {
            int middle = low + (high - low)/2;
            if(element > a[middle])
                low = middle + 1;
            else
                high = middle;
        }
        return low;
    }

    // Driver code
    public static void main(String[] args)
    {
        int p = 62;
        System.out.println(maxPeople(p));
    }
}

