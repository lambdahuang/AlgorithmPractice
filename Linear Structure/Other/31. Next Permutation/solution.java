// method 1
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
// method 2

    public void nextPermutation(int[] nums) {
        if(nums.length <= 1) return;
        int index = -1;
        for(int i = nums.length - 2; i >= 0 ;i --)
            if(nums[i+1] > nums[i]) {index = i; break;}
        if(index == -1) {reverse(nums, 0); return;}
        int cloest = index + 1;
        for(int i = index+1; i < nums.length; i ++)
            cloest = nums[i] > nums[index] && nums[i] <= nums[cloest]? i:cloest;
        swap(nums, index, cloest);
        reverse(nums, index + 1);
        return;
    }
    public void reverse(int[] nums, int start)
    {
        int len = (nums.length - start)/2;
        for(int i = 0; i < len; i ++)
            swap(nums, i + start, nums.length - 1 - i);
        return;
    }
    public void swap(int[] nums, int i, int j)
    {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
