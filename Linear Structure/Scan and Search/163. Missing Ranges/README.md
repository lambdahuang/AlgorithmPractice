[163. Missing Ranges](https://leetcode.com/problems/missing-ranges/description/)

Be careful the boundry, if you assume a number give by the question deducted by one is still valid, you are better to use a long to catch up the result of such kind of calculation.

```
class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new LinkedList();
        long start = lower;
        for(int num : nums)
        {
            if(num - 1 == start) 
                ans.add(Integer.toString((int)start));
            else if(num > start)
            {
                StringBuilder sb = new StringBuilder();
                sb.append(start);
                sb.append("->");
                sb.append(num-1);
                ans.add(sb.toString());
            }
            start = (long)num + 1;
        }
        if(start == (long)upper) ans.add(Integer.toString((int)start));
        else if(start < (long)upper) 
        {
            StringBuilder sb = new StringBuilder();
            sb.append(start);
            sb.append("->");
            sb.append(upper);
            ans.add(sb.toString());
        }
        return ans;
    }
}
```
