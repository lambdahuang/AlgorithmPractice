This question belongs to the set of subarray set questions.

[325. Maximum Size Subarray Sum Equals k](https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/description/)

I'd like to make a comparison between this question with [209. Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/description/).

Both questions look for a **contiguous subarray** which sum of the subarray satisfies some conditions.

However, there are several differences:

1. In the question of **209. Minimum Size Subarray Sum**, we are looking for having the sum of subarray greater than a given value of k.
However, the question of **325. Maximum Size Subarray Sum Equals k** is looking for a subarray which sum is equal to k.
This is a huge difference which ultimately leads us to a two different data structures.
For the question of accurate looking up, we can use either array or hashtable based data structure such as hashmap, hashset, etc,. 
However, for the range query, the most if not all of time, we can only use the array or tree-based solution such as treemap.

2. Two question are actually using opposite optimization strategy, one is seeking for a minimal length of subarray while the other is finding the maximal length of subarray.

3. For #209. Minimum Size Subarray Sum#, we are working with an array with all positive elements,
while, in the question of **325. Maximum Size Subarray Sum Equals k**, the negative elements are also allowed in the array.

Considering we have these differences, we would not reuse the most part of our strategy for question **209. Minimum Size Subarray Sum**.

Here is my solution with `HashMap`:

```
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if(nums.length == 0) return 0;
        int[] map = new int[nums.length + 1];
        HashMap<Integer, Integer> hm = new HashMap();
        int max = 0;
        for(int i = 0; i < nums.length; i ++) map[i + 1] = nums[i] + map[i];
        for(int i = map.length - 1; i >= 0; i --) hm.put(map[i], i);
        for(int i = map.length - 1; i >= 0; i --)
        {
            int tmp = map[i]  - k;
            Integer x = hm.getOrDefault(tmp, null);
            if(x != null)
                max = Math.max(max, i - x);
        }
        return max;
    }
}
```

Each element in the array of map represents the sum of subarray of nums starting from 0 to the position of the element.

We can iterate the array to find the end point of subarray, and do a simple math to find a expected start point.

Then `HashMap` could help us to find the furthest start point satisfying our expectation. 

You may notice that I set up the hashmap using reverse order of the array of map.

The reason behind this is that we're seeking for having the maximized subarray given a map[i] and a k.
