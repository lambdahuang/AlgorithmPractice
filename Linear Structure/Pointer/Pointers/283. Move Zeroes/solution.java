class Solution {
    public void moveZeroes(int[] nums) {
        int[]map = new int[nums.length + 1];
        for(int i = 1; i <= nums.length; i++)
            if(nums[i-1] == 0)
                map[i] = 1 + map[i - 1];
            else
                map[i] = map[i-1];

        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i]!=0)
                nums[i-map[i]] = nums[i];
        }
        for(int i = nums.length - map[map.length - 1]; i < nums.length; i ++ )
            nums[i]=0;
        return;
    }
}
