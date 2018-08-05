class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length <= 1) return;
        TreeMap<Integer, Integer> mp = new TreeMap();
        for(int i = nums.length - 1; i >= 0; i --)
        {
            Integer higherkey = mp.higherKey(nums[i]);
            if(higherkey != null)
            {
                int index = mp.get(higherkey);
                if(index > i)
                {
                    //exchange
                    int tmp = nums[index];
                    nums[index] = nums[i];
                    nums[i] = tmp;

                    //sort
                    Arrays.sort(nums, i + 1, nums.length);
                    return;
                }
            }
            mp.put(nums[i], i);
        }
        Arrays.sort(nums);
        
    }
}
