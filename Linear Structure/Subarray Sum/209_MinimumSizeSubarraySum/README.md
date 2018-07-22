This question can be solved by either optimized two-pointers linear scan or binary search.

The formmer one takes O(n) which is optimal solution. However, the latter one is still instructive.

optimized two-pointer scans

```
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int[] map = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i ++)
            map[i + 1] = map[i] + nums[i];
        int left = 0;
        int right = 1;
        int min = Integer.MAX_VALUE;
        while(left < right && right < map.length)
        {
            int tmp = map[right] - map[left];
            if(tmp >= s) min = Math.min(right-left, min);
            if(tmp >= s)
                left ++;
            else
                right ++;
        }
        return min == Integer.MAX_VALUE? 0: min;
    }
}
```

Binary search via TreeMap

```
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int[] map = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i ++)
            map[i + 1] = map[i] + nums[i];
        TreeMap<Integer, Integer> tm = new TreeMap();
        for(int i = 0; i < map.length; i ++)
            tm.put(map[i], i);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < map.length; i++)
        {
            Integer n = tm.higherKey(map[i] + s - 1);
            if(n != null)
            {
                int index = tm.get(n);
                min = Math.min(index - i, min);
            }
        }
        return min == Integer.MAX_VALUE? 0:min;
    }
}
```
