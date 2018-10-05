[350. Intersection of Two Arrays II](https://leetcode.com/problems/intersection-of-two-arrays-ii/)

```
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> ans = new LinkedList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int left = 0;
        int right = 0;
        while(left < nums1.length && right < nums2.length)
        {
            if(nums1[left] == nums2[right]) {ans.add(nums1[left]); left++; right++;}
            else if(nums1[left]>nums2[right]) right++;
            else left ++;
        }
        int[] arr = new int[ans.size()];
        int j = 0;
        for(int i : ans) arr[j++] = i;
        return arr;
    }
}
```
