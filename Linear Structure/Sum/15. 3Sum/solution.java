class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new LinkedList();
        if(nums == null || nums.length < 3) return ret;
        Arrays.sort(nums);
        int tmp = nums[0] + 1;
        for(int i = 0; i < nums.length - 2; i++)
        {
            if(nums[i] == tmp) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right)
            {
                int sum = nums[left] + nums[right] + nums[i];
                if(sum == 0) {
                    List<Integer> res = new LinkedList();
                    res.add(nums[i]);
                    res.add(nums[left]);
                    res.add(nums[right]);
                    ret.add(res);
                    int curLeft = left;
                    int curRight = right;
                    while(left < right && nums[left] == nums[curLeft])left ++;
                    
                }
                else if(sum < 0) left ++;
                else right --;
            }
            tmp = nums[i];
        }
        
        return ret;
    }
}
