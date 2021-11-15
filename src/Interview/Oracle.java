package Interview;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Oracle {

    static Map<String, Long> throttleConfig = new HashMap<>();
    static Map<String, Long> maxCredit = new HashMap<>();
    static long windowTime = System.currentTimeMillis();
    static ConcurrentHashMap<String, Long> currRequests = new ConcurrentHashMap<>();
    static ConcurrentHashMap<String, Long> credit = new ConcurrentHashMap<>();

    public static void fulfillRequest(String customerId) throws InterruptedException {
        long currTime = System.currentTimeMillis();
        long timeDiff = currTime - windowTime;// synchronised
        if(timeDiff >= 1000){
            windowTime = System.currentTimeMillis();// synchronised
            long currTps = currRequests.get(customerId);// synchronised
            long maxCreditAllowed = maxCredit.get(customerId);
            long currCredit = throttleConfig.get(customerId)  - currTps;
            currCredit = Math.min(currCredit, maxCreditAllowed);
            credit.put(customerId, currCredit );
            currRequests.put(customerId,0L);// synchronised
        }else{
            long currTps = currRequests.get(customerId);// synchronised
            if(currTps < (throttleConfig.get(customerId) + credit.get(customerId))){
                currRequests.put(customerId,currRequests.getOrDefault(customerId, 0L)+1 );// synchronised
                Thread.sleep(500);
            }else {
                throw new RuntimeException("Throttled. Please reduce your request rate and retry");
            }
        }

    }

    public static void main(String[] args) {
        throttleConfig.put("1", 1000L);
    }

}


// 1:00 - 1:01
// 1:00.5 - 1.01.5
// Active requests