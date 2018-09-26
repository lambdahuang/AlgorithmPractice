class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length - 1, j = m - 1, k = n - 1;
        while(i >= 0){
            nums1[i--] = (j>=0&&k>=0)?((nums2[k]>nums1[j])?nums2[k--]:nums1[j--]):((j<0)?nums2[k--]:nums1[j--]);
        }
    }
}
