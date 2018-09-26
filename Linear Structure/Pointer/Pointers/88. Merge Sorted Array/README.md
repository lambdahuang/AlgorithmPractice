[88. Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/)

We use two pointers to mark an windows.

Once head-pointer moved, the tail-pointer would try to find the next position that makes the characters in the windows covering all characters in target string.

```
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length - 1, j = m - 1, k = n - 1;
        while(i >= 0){
            nums1[i--] = (j>=0&&k>=0)?((nums2[k]>nums1[j])?nums2[k--]:nums1[j--]):((j<0)?nums2[k--]:nums1[j--]);
        }
    }
}
```
