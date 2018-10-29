[300. Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/)

"""
class Solution {
    public int lengthOfLIS(int[] nums) {
        int max_length = 0;
        int[] map = new int[nums.length];
        for(int i = 0; i < nums.length; i ++)
        {
            int cur = 0;
            for(int j = 0; j < i; j ++)
                if(nums[i] > nums[j]) 
                    cur = Math.max(cur, map[j]);
            map[i] = cur + 1;
            max_length = Math.max(max_length, map[i]);
        }
        return max_length;
    }
}
"""

The second method is O(nlogn), the strategy is quite smart. Basically, it borrow the idea of the stack and binarySearch.
```
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] map = new int[nums.length];
        int len = 0;
        for(int x : nums)
        {
            int l = Arrays.binarySearch(map, 0, len, x);
            l = l<0? -(l+1): l;
            map[l] = x;
            if(l == len) len ++;
        }
        return len;
    }
}
```
