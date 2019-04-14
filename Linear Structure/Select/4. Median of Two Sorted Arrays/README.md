[4. Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/)

My solution uses two pointers, each of which is pointing to an array. 
By compare the numbers from two arrays pointed by the pointers, we shift the pointer of lesser value by one step. For each movement, we know the kth elements in both array. if the k equals to the median value, we perform the calculation.

```
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l = 0;
        int r = 0;
        int k = 1;
        int lenTotal = (nums1.length + nums2.length);
        int middle = (lenTotal+1) / 2;
        double res = 0;
        
        while(true) {
            if(l < nums1.length && (r >= nums2.length || nums1[l] < nums2[r])) {
                if(k == middle) {
                    if(lenTotal%2==1)
                        return nums1[l];
                    else
                        res += nums1[l];
                } else if(k==middle+1 && lenTotal%2==0) {
                    return (res + nums1[l])/2;
                }
                l ++;
            } else {
                if(k == middle) {
                    if(lenTotal%2==1)
                        return nums2[r];
                    else
                        res += nums2[r];
                } else if(k==middle+1 && lenTotal%2==0) {
                    return (res + nums2[r])/2;
                }
                r ++;
            }
            k++;
        }
    }
}
```
