[911. Online Election](https://leetcode.com/problems/online-election/)

You only need to keep tracking on the candidates with max votes across all discrete timestamp. Treemap would give you the benefit to link a given time to a nearest time bin.


```
class TopVotedCandidate {
    TreeMap<Integer, Integer> tm = new TreeMap();
    public TopVotedCandidate(int[] persons, int[] times) {
        int[] votes = new int[persons.length];
        int max = 0;
        int max_id = 0;
        for(int i = 0; i < persons.length; i ++){
            votes[persons[i]] += 1;
            if(votes[persons[i]] >= max) {max = votes[persons[i]]; max_id = persons[i];}
            tm.put(times[i], max_id);
        }
    }
    
    public int q(int t) {
        Integer lowk = tm.lowerKey(t+1);
        return tm.get(lowk);
    }
}
```

Although the Treemap give you O(logn) to map a time to a nearest time bin, but you still can do some optimization. For example, if you can assign your time bin with better granularity -- you know the max possible time and you can assign each time bin with 1 unit of time, and fill the candidate ids into this 1-unit time bin. The tradeoff would be memory usage.
