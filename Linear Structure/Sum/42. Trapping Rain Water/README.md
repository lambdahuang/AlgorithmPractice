[42. Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/)
The trick would be how to decomplex the question.

By split the array into two at the highest element, you can greatly decompose the question into two identical subquestions.

```
class Solution {
    public int trap(int[] height) {
        if(height.length < 3) return 0;
        int highestIndex = -1;
        int heighest = 0;
        for(int i=0;i < height.length; i++)
            if(height[i] > heighest){highestIndex = i; heighest = height[i];}
        int current = height[0];
        int count = 0;
        for(int i = 0; i < highestIndex; i ++)
        {
            if(height[i] < current)
                count+=current-height[i];
            else
                current = height[i];
        }
        current = height[height.length-1];
        for(int i = height.length-1; i> highestIndex; i --)
        {
            if(height[i] < current)
                count+=current-height[i];
            else
                current = height[i];
        }
        return count;
    }
}
```
