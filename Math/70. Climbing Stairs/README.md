[70. Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)

This is a math problem.
```
class Solution {
    public int climbStairs(int n) {
        if(n == 0) return 1;
        else if(n == 1) return 1;
        else if(n == 2) return 2;
        int nmo = 2; // n - 1
        int nmt = 1; // n - 2
        int tmp  = 0;
        for(int i = 3; i <= n; i ++)
        {
            tmp = nmo + nmt;
            nmt = nmo;
            nmo = tmp;
        }
        return tmp;
    }
}
```
