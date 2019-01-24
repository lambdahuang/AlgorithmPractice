[159. Longest Substring with At Most Two Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/)

This question is pretty like [904. Fruit Into Baskets](https://github.com/lambdahuang/AlgorithmPractice/tree/master/Linear%20Structure/Pointer/Sliding%20Window/904.%20Fruit%20Into%20Baskets)

```
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length() <= 2) return s.length();
        char[] arr = s.toCharArray();
        int left = -1;
        int last_diff = -1;
        int max_len = 0;
        if(arr[0] != arr[1]) last_diff = 0;
        for(int i = 2; i < arr.length; i ++)
        {
            if(arr[i] != arr[i-1])
            {
                if(last_diff != -1) 
                {
                    if(arr[last_diff]!=arr[i])
                        left = last_diff;
                    else
                        max_len = Math.max(i-left,max_len);
                }
                // update last place that two continuous chars are different.
                last_diff=i-1;
            }
            max_len = Math.max(i-left,max_len);
            
        }
        return max_len;
    }
}
```

