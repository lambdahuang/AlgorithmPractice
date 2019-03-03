[849. Maximize Distance to Closest Person](https://leetcode.com/problems/maximize-distance-to-closest-person/)

# Naive Solution

```
class Solution {
    public int maxDistToClosest(int[] seats) {
        TreeSet<Integer> ts = new TreeSet<>();
        for(int i = 0; i < seats.length; i ++) 
            if(seats[i] == 1) ts.add(i);
        int max = 0;
        for(int i = 0; i < seats.length; i  ++) {
            if(seats[i] != 0) continue;
            Integer l = ts.lower(i);
            Integer h = ts.higher(i);
            int minL = (l != null)?i-l:Integer.MAX_VALUE;
            int minH = (h != null)?h-i:Integer.MAX_VALUE;
            max = Math.max(max, Math.min(minL, minH));
        }
        return max;
    }
}
```

# O(n) solution

Be careful on the initial value of lastPerson, I was setting it as Integer.MIN_VALUE.
It turns out that Integer.MIN_VALUE is a bad idea becasue you would overflow once you use any integer minus it.
Then, I set it as -1, which is also a stupid idea because you want to make sure that, once the first position is empty, the left distance should be greater then any possible value of the right distance, in that way you can take the left distance off from your scope when running the Math.min().
Eventually, I read the restriction of the question and set the lastPerson to -20000, which would give you a value always greater then all possible distance.

```
    public int maxDistToClosest(int[] seats) {
        int lastPerson = -20000;
        int max = 0;
        for(int i = 0; i < seats.length; i ++) {
            if(seats[i] == 1) {
                int mid = 0;
                if(lastPerson >= 0) mid = (lastPerson + i) / 2;
                int minDis = Math.min(mid - lastPerson, i - mid);
                max = Math.max(minDis, max);
                lastPerson = i;
            }
            if(i == seats.length-1 && seats[i] == 0) {
                max = Math.max(i - lastPerson , max);
            }
        }
        return max;
    }
```
