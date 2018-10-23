[53. Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)
```
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;
        int currentSum = 0;
        int currentMin = 0;
        int currentMax = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i ++)
        {
            currentSum += nums[i];
            currentMax = Math.max(currentMax, currentSum - currentMin);
            currentMin = Math.min(currentSum, currentMin);
        }
        return currentMax;
    }
}
```
