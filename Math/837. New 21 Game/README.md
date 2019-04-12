[837. New 21 Game](https://leetcode.com/problems/new-21-game/)

Both are DP solutions, but the second is using a sum value to keep tracking on last W elements, and by doing so, we save a for-loop.

O(K*W)

```
class Solution {
    public double new21Game(int N, int K, int W) {
        if(K == 0) return 1;
        double[] map = new double[K+W+1];
        for(int i = 1; i <= W; i++) map[i] = 1/(double)W;
        for(int i = 1; i < K; i ++)
            for(int j = 1; j<=W ; j ++)
                map[j+i] += map[i] * 1/(double)W;
        double sum = 0;
        for(int i = K; i <= N; i ++)
            sum += map[i];
        return sum;
    }
}    
```

O(K+W) solution

```
class Solution {
    public double new21Game(int N, int K, int W) {
        if(K == 0) return 1;
        double r = 1/(double)W;
        double[] map = new double[K+W];
        for(int i = 1; i <= W; i++) map[i] = r;
        
        double tmp = 0;
        for(int i = 1; i < K+W; i ++) {
            map[i] += tmp * r;
            if(i < K) tmp += map[i];
            if(i>W ) tmp -= map[i-W];
        }
        double sum = 0;
        for(int i = K; i <=N; i ++) {
            sum += map[i];
        }
        return sum;
    }
}
```
