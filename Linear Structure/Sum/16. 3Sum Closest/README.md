[16. 3Sum Closest](https://leetcode.com/problems/3sum-closest/)

This is simliar to the 3Sum.

```
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3) return 0;
        Arrays.sort(nums);
        int cloestestValue = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length - 2; i++)
        {
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right)
            {
                int tmp = nums[i] + nums[left] + nums[right];
                if(Math.abs(tmp - target) < Math.abs(cloestestValue - target))
                    cloestestValue = tmp;
                if(tmp == target)
                    return target;
                else if(tmp < target)
                    left ++;
                else
                    right --;
            }
        }
        return cloestestValue;
    }
}
```
