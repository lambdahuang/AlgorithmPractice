[410. Split Array Largest Sum]()


# DFS (bruteforce) TLE

```
class Solution {
    public int splitArray(int[] nums, int m) {
        int[] cum = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++)
            cum[i + 1] = cum[i] + nums[i];
        int ret = DFS(cum, m, 0, 0);
        return ret;
    }
    public int DFS(int[] cum, int m, int index, int current_max) {
        if(index==cum.length-1&&m>0 ||
           m==0 &&index!=cum.length-1)
            return Integer.MAX_VALUE;
        else if(index == cum.length-1 && m == 0)
            return current_max;
        int ret = Integer.MAX_VALUE;
        for(int i = index + 1; i <= cum.length - m;i ++) {
            ret = Math.min(
                DFS(cum, m-1, i, Math.max(current_max, cum[i] - cum[index])),
                ret);
        }
        return ret;
    }
}
```

# 2-D DP

```
class Solution {
    public int splitArray(int[] nums, int m) {
        long[] cum = new long[nums.length + 1];
        for(int i = 0; i < nums.length; i++)
            cum[i + 1] = cum[i] + nums[i];
        long[][] map = new long[m + 1][nums.length+1];
        for(int i = 0; i < cum.length; i ++) map[1][i] = cum[i];
        for(int j = 2; j <= m; j++)
        {
            for(int i = 0; i < cum.length-(m-j); i ++)
            {
                map[j][i] = Integer.MAX_VALUE;
                for(int k = 0; k < i; k ++ )
                    map[j][i] = Math.min(
                    Math.max(map[j-1][k], cum[i] - cum[k]),
                    map[j][i]);
            }
        }
        return (int)map[m][nums.length];
    }
}
```
