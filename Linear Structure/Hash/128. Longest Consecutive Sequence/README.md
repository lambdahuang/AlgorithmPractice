[128. Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/)

The question is pretty similar to the question that requires you to return the number of disconnected componenet from a set of nodes from a deque.

```
class Solution {
    public int longestConsecutive(int[] nums) {
        int maxlen = 0;
        HashSet<Integer> hs = new HashSet();
        for(int i = 0; i < nums.length; i ++) hs.add(nums[i]);
        for(int i = 0; i < nums.length && hs.size() != 0; i ++)
        {
            if(!hs.contains(nums[i])) continue;
            int tar = nums[i];
            int len = 1;
            int tmp = tar - 1;
            while(hs.contains(tmp)) {hs.remove(tmp); tmp --; len ++;}
            tmp = tar + 1;
            while(hs.contains(tmp)) {hs.remove(tmp); tmp ++; len ++;}
            maxlen = Math.max(len, maxlen);
        }
        return maxlen;   
    }
}
```
