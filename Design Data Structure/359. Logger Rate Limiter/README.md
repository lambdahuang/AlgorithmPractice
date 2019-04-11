[359. Logger Rate Limiter](https://leetcode.com/problems/logger-rate-limiter/)

```
class Logger {
    HashMap<String, Integer> hm = new HashMap<>();
    /** Initialize your data structure here. */
    public Logger() {
        
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        int lastSeen = hm.getOrDefault(message, -1);
        if(lastSeen == -1 || timestamp - lastSeen >= 10) {
            hm.put(message, timestamp);
            return true;
        } else {
            return false;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
```
