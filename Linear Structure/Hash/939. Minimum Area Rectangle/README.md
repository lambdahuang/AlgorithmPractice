[939. Minimum Area Rectangle](https://leetcode.com/problems/minimum-area-rectangle/)

O(N^2) solution optimized bruteforce  NP-complete question

```
class Solution {
    public int minAreaRect(int[][] points) {
        HashMap<Integer, HashSet<Integer>> xy = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> yx = new HashMap<>();
        for(int i = 0; i < points.length; i ++)
        {
            xy.putIfAbsent(points[i][0], new HashSet());
            xy.get(points[i][0]).add(points[i][1]);
            
            yx.putIfAbsent(points[i][1], new HashSet());
            yx.get(points[i][1]).add(points[i][0]);
        }
        int minArea = Integer.MAX_VALUE;
        for(int i = 0; i < points.length; i ++)
            for(int j = 0; j < points.length; j ++)
            {
                if(points[i][0] == points[j][0] || points[i][1] == points[j][1])
                    continue;
                if(xy.get(points[i][0]).contains(points[j][1]) && 
                   yx.get(points[i][1]).contains(points[j][0]))
                    minArea = Math.min(Math.abs((points[i][0] - points[j][0]) * 
                                      (points[i][1] - points[j][1])), minArea);
                
            }
        if(minArea == Integer.MAX_VALUE)
            return 0;
        else
            return minArea;
    }
}
```
