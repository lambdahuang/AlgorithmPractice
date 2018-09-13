
```
class LRUCache {
    Deque<Integer> dq = new ArrayDeque<>();
    Deque<Integer> dqi = new ArrayDeque<>();
    HashMap<Integer, Integer> hm = new HashMap();
    HashMap<Integer, Integer> map = new HashMap();
    
    int k = 0;
    int index = 0;
    public LRUCache(int capacity) {
        k = capacity;
    }

    public int get(int key) {
        index ++;
        if(!hm.containsKey(key)) return -1; 
        dq.add(key);
        dqi.add(index);
        map.put(key, index);
        return hm.get(key);
    }
    
    public void put(int key, int value) {
        index ++;
        hm.put(key, value);
        map.put(key, index);
        dq.add(key);
        dqi.add(index);
        while(hm.size() > k)
        {
            int candidate = dq.poll();
            int candidateIndex = dqi.poll();
            if(map.containsKey(candidate) && candidateIndex == map.get(candidate))
            {
                hm.remove(candidate);
                map.remove(candidate);
            }
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCaæche(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
```
