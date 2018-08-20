[215. Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/description/)

It's a good practice for the algorithm of QuickSelect. 

```
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // QuickSelect
        if(k <= 0 || k > nums.length) return 0;
        return select(nums, 0, nums.length - 1, k - 1);
    }
    public int partition(int[] nums, int left, int right, int pivot)
    {
        int pivotNum = nums[pivot];
        swap(nums, pivot, right);
        int storeIndex = left;
        for(int i = left; i <= right - 1; i ++)
            if(nums[i] > pivotNum){
                swap(nums, i, storeIndex);
                storeIndex++;
            }
        swap(nums, right, storeIndex);
        return storeIndex;
    }
    public int select(int[] nums, int left, int right, int k)
    {
        if(left == right) return nums[left];
        int pivot = (left + right) / 2;
        pivot = partition(nums, left, right, pivot);
        if(k == pivot) return nums[pivot];
        else if(k < pivot) return select(nums, left, pivot - 1, k);
        else return select(nums, pivot + 1, right, k);
    }
    public void swap(int[] nums, int i, int j)
    {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
```
