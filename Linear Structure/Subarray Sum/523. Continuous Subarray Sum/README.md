[523. Continuous Subarray Sum](https://leetcode.com/problems/continuous-subarray-sum/description/)


# Iterative solution

```
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length < 2) return false;
        int[] cum = new int[nums.length + 1];
        for(int i = 1; i <= nums.length; i ++) cum[i] = cum[i - 1] + nums[i - 1];
        for(int i = 2; i <= nums.length; i ++)
        {
            for(int j = 0; j <= nums.length - i; j++)
            {
                int tmp = cum[j + i] - cum[j];
                if((tmp == 0)||
                   (k != 0 && tmp != 0 && (tmp % k) == 0))
                        return true;
            }
        }
        return false;
    }
}
```

# HashMap

