```
class Solution {
    public int search(int[] nums, int target) {
        //System.out.println("---");
        if(nums.length == 0) return -1;
        return binarySearch(nums, 0, nums.length - 1, target);
    }
    public int binarySearch(int[] nums, int start, int end, int target)
    {
        int ans = -1;
        int mid = (int)(start/2.0 + end/2.0);
        int val = nums[mid];
        if(start > end) return ans;
        else if(start == end) 
        {
            //System.out.println(start);
            if(val != target)
                return ans;
            else
                return start;
        }
        if(target == val) 
            return mid;
        else if(target > val)
        {
            ans = binarySearch(nums, mid + 1, end, target);
            if(ans == -1) ans = binarySearch(nums, start, mid - 1, target);
        }
        else // target < val
        {
            ans = binarySearch(nums, start, mid - 1, target);
            if(ans == -1) ans = binarySearch(nums, mid + 1, end, target);
        }
        return ans;
    }
}
```
