package RateLimiter;

import java.security.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * limits: They define the limit for each resource, customer_id pair. Each line in limits is a
 *  3-tuple in the following format <resouceId customerId maxQps>
 * client: Use the client.callAPI() to invoke the service. This always returns true.
 *
 * The task is to ensure that you never exceed the QPS of each resourceId, customerId specified in limits when calling callAPI.
 */
public class RateLimiter {
    ServiceInterface client;
    Map<String,Integer> clientLimits = new HashMap<>();
    long transactions;
    long initialTime;
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();


    public RateLimiter(List<String> limits, ServiceInterface client) {
        // Parse the limits variable to find out what the limits for each resourceId customerId pair into whatever datastructure that is convenient to you.
        this.client = client;
        // Assuming limits always come in the format
        // 'resouceId customer_id qps'
        limits.stream().forEach(l -> {
            String[]  array = l.split(" ");
            this.clientLimits.put(array[0]+"_"+array[1],Integer.parseInt(array[2]));
        });
        initialTime = System.currentTimeMillis();
    }

    /**
     This is the ONLY method that you need to implement.
     returns: A long representing the number of milliseconds that callAPI should wait before invoking client.callService in order to respect the limits for this resourceId, customerId pair (as specified in the limits passed to the constructor).
     */
    private long canExecute(String resourceId, String customerId) {
        int limit = clientLimits.get(resourceId+"_"+customerId);
        if(transactions == 0) {
            transactions ++;
            initialTime = System.currentTimeMillis();
            return 0;
        }
        transactions++;
        lock.writeLock().lock();
        long curr = System.currentTimeMillis();
        if (curr > initialTime +1000L  ){
            initialTime = curr;
            transactions = 0;
            lock.writeLock().unlock();
            return 0L;
        }
        if(transactions < limit){
            lock.writeLock().unlock();
            return 0L;
        }else{
            long pendingTime = (initialTime +1050L - curr);
            lock.writeLock().unlock();
            return  pendingTime;
        }
    }

    /**
     Anyone who wants to invoke ServiceInterface.callService needs to do so through the RateLimiter to do this in a rate-limited manner. The rate limiter will wait to make the call if necessary in order to respect the qps
     */
    public boolean callAPI(String resourceId, String customerId) throws InterruptedException {
        long waitTime = canExecute(resourceId, customerId);
        if (waitTime > 0) {
            Thread.sleep(waitTime);
        }
        this.client.callService(resourceId, customerId);
        return true;
    }

}
