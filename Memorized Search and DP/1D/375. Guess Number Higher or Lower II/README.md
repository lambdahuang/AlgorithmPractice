[375. Guess Number Higher or Lower II]()

This is not a question of binary search.

```
class Solution {
    public int getMoneyAmount(int n) {
         int[][] map = new int[n+1][n+1];
        for(int i = 1; i <= n; i ++)
        {
            map[i][i] = 0;
            if(i+1<=n)map[i][i+1] = i;
        }
        for(int i = 2; i <=n; i++)
            for(int j = 1; j <= n-i; j ++)
            {
                // j - j+i
                int tmp = Integer.MAX_VALUE;
                for(int k = j; k <=j+i; k++)
                {
                    tmp = Math.min(tmp, k + Math.max((k-1>=j?map[j][k-1]:0), (k+1<=j+i?map[k+1][j+i]:0)));
                }
                map[j][j+i]=tmp;
            }
        return map[1][n];
    }
}
```
