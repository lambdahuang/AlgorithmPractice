class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ret = new int[nums.length];
        if(nums.length == 0) return ret;
        ret[0] = 1;
        for(int i = 1; i < nums.length; i++)
            ret[i] = ret[i-1] * nums[i - 1];
        int mul = 1;
        for(int i = nums.length - 2; i >= 0; i--)
        {
            mul *= nums[i + 1];
            ret[i] *= mul;
        }   
        return ret;
    }
}
