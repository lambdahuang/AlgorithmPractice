[523. Continuous Subarray Sum](https://leetcode.com/problems/continuous-subarray-sum/description/)


Be careful, the edge cases are dangerous.
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
```
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length < 2) return false;
        // Two continuous "0" will form a subarray which has sum = 0. 0 * k == 0 will always be true.
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0 && nums[i + 1] == 0) return true;
        }
        if(k == 0) return false;
        int sum = 0;
        HashMap<Integer, Integer> hm = new HashMap();
        hm.put(0, 0);
        for(int i = 0; i < nums.length; i ++)
        {
            sum += nums[i];
            sum %= k;
            if(hm.containsKey(sum))
            {
                if(i + 1 - hm.get(sum) > 1)
                    return true;
            }
            else
                hm.put(sum, i + 1);
        }
        return false;
    }
}
```
