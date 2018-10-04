[256. Paint House](https://leetcode.com/problems/paint-house/)

```
class Solution {
    public int minCost(int[][] costs) {
        int[][] map = new int[costs.length+1][3];
        for(int i = 0; i < costs.length; i++)
        {
            map[i+1][0] = costs[i][0] + Math.min(map[i][1], map[i][2]);
            map[i+1][1] = costs[i][1] + Math.min(map[i][0], map[i][2]);
            map[i+1][2] = costs[i][2] + Math.min(map[i][0], map[i][1]);
        }
        return Math.min(Math.min(map[costs.length][0], map[costs.length][1]), map[costs.length][2]);
    }
    
}
```
