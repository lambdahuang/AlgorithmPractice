[277. Find the Celebrity](https://leetcode.com/problems/find-the-celebrity/description/)
It's a quite good pruning question.

The tricky part is that you should not start with finding the answer,
instead, you should try to filter out those impossible cases.
We call this pruning.

```
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        if(n == 1) return 0;
        int candidate = 0;
        for(int i = 1; i < n; i ++)
        {
            if(knows(candidate, i)==true || knows(i, candidate)==false) candidate = i;
        }
        for(int i = 0; i < n; i ++)
            if(i != candidate && (knows(i, candidate) == false || knows(candidate, i) == true))
                return -1;
        return candidate;
                
    }
}
```
