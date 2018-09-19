[629. Top K Frequent Words](https://leetcode.com/problems/top-k-frequent-words/)

# Using Tree Map

```
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> hm = new HashMap();
        for(String word : words)
            hm.put(word, hm.getOrDefault(word, 0) + 1);
        TreeMap<Integer, List<String>> rhm = new TreeMap();
        Iterator it = hm.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry pair = (Map.Entry)it.next();
            Integer val = (Integer)pair.getValue();
            String key = (String)pair.getKey();
            List<String> lst = rhm.getOrDefault(val,
                                               new LinkedList());
            lst.add(key);
            rhm.put(val, lst);
        }
        List<String> ret = new ArrayList(k);
        Integer max = (Integer)rhm.lastEntry().getKey();
        while(k>0 && max != null)
        {
            List<String> lst = rhm.get(max);
            Collections.sort(lst);
            for(String x: lst)
            {
                ret.add(x);
                if(--k <= 0) break;
            }
            max = rhm.lowerKey(max);
        }
        return ret;
    }
}
```

# Using Heap

While using priority queue might be the expected solutoin but the treemap can achieve the same performance in the worst case. 

```
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> hm = new HashMap();
        for(String word : words)
            hm.put(word, hm.getOrDefault(word, 0) + 1);
        TreeMap<Integer, List<String>> rhm = new TreeMap();
        Iterator it = hm.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry pair = (Map.Entry)it.next();
            Integer val = (Integer)pair.getValue();
            String key = (String)pair.getKey();
            List<String> lst = rhm.getOrDefault(val,
                                               new LinkedList());
            lst.add(key);
            rhm.put(val, lst);
        }
        List<String> ret = new ArrayList(k);
        
        PriorityQueue<Map.Entry<String, Integer>> pq = 
            new PriorityQueue<>( (a, b)->a.getValue()==b.getValue()?b.getKey().compareTo(a.getKey()):a.getValue() - b.getValue());
        
        for(Map.Entry e : hm.entrySet())
        {
            pq.offer(e);
            if(pq.size() > k) pq.poll();
        }
        while(!pq.isEmpty()) ret.add(0, pq.poll().getKey());
        return ret;
    }
}
```
