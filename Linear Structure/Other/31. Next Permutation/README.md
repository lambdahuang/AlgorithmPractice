[31. Next Permutation](https://leetcode.com/problems/next-permutation/description/)

# Solution 1

The first solution I have in mind is using the treemap.

The basical idea of this method is to first find two number A and B,
which A and B satisfy following condition:

* the index of A is smaller than the index of B.
* A is smaller than B, so exchange A and B will give us a sequence with larger lexicographically order.
* the index of A should be as large as possible.
* the value of B should be as smaller as possible.




```
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
```

