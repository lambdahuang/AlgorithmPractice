class Solution {
    public boolean circularArrayLoop(int[] nums) {
        for(int i = 0; i < nums.length; i ++)
            if(test(nums, i)) return true;
        return false;
    }
    public boolean test(int[] nums, int start)
    {
        if(nums.length == 0) return false;
        int slow = start;
        int fast = start;
        boolean mark = true;
        boolean met = false;
        boolean single_direction = false;
        int previous_fast = 0;
        while(true)
        {
            int pre = fast;
            fast += nums[fast];
            fast = (fast + nums.length)%nums.length;
            if(met == true && (nums[fast]/Math.abs(nums[fast])) != previous_fast || (pre == fast))
                return false;
            fast += nums[fast];
            fast = (fast + nums.length)%nums.length;
            if(met == true && (nums[fast]/Math.abs(nums[fast])) != previous_fast)
                return false;

            slow += nums[slow];
            slow = (slow + nums.length)%nums.length;
            if(slow == fast) 
            {
                if(met == false) 
                {
                    met = true;
                    previous_fast = nums[slow]/Math.abs(nums[slow]);
                }
                else
                    return true;
            }
        }
    }
}
