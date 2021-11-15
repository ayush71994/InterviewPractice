package RateLimiter;

/**
 This is the interface to your service. In the real world, this would've been a client e.g http/websocket that
 would've made a call to the service over the internet.
 */
public interface ServiceInterface {
    public boolean callService(String resourceName, String customerId);
}
