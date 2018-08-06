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

Because we used the comparison-based sorting algorithm, the time complexity of this method is O(nlogn)

# Solution 2
There is actually one method even better than this.
Do you remember we are actually exchanging the last decreasing order element with the last element which is closest and larger than decreasing order one.

Two conclusions we will have:

* the elements behind the last decreasing order element should be in increasing order.
* exchanging as I stated formerlly would not actually change the increasing order for elements behind the last decreasing element for two reason:
1. the exchanged element is larger than the original element.
2. the elements behind the replaced element  have to be smaller than the original elements.

```
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
```
