[886. Possible Bipartition](https://leetcode.com/problems/possible-bipartition/description/)


# BFS + HashMap

```
class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        // Mapify
        HashMap<Integer, List<Integer>> hm = new HashMap();
        for(int[] dislike: dislikes)
        {
            List<Integer> tmp = hm.getOrDefault(dislike[0], new LinkedList());
            tmp.add(dislike[1]);
            hm.put(dislike[0], tmp);
            
            tmp = hm.getOrDefault(dislike[1], new LinkedList());
            tmp.add(dislike[0]);
            hm.put(dislike[1], tmp);
        }
        HashSet<Integer> visited = new HashSet();
        for(int i = 1; i <= N; i ++)
        {
            if(visited.contains(i)) continue;
            Deque<Integer> dq = new ArrayDeque();
            HashSet<Integer> A = new HashSet();
            HashSet<Integer> B = new HashSet();
            dq.addFirst(i);
            boolean flipMark = true;
            while(dq.size() != 0)
            {
                int qSize = dq.size();
                for(int j = 0; j < qSize; j++)
                {
                    int index = dq.removeLast();
                    visited.add(index);
                    if(flipMark) A.add(index); else B.add(index);
                    List<Integer> dislike = hm.getOrDefault(index, new LinkedList());
                    for(int x : dislike)
                    {
                        if(flipMark && A.contains(x)) {return false;}
                        else if(!flipMark && B.contains(x)) {return false;}
                        if(A.contains(x) || B.contains(x)) continue; else dq.addFirst(x);
                    }
                }
                flipMark = !flipMark;
            }
        }
        return true;
    }
}
```

