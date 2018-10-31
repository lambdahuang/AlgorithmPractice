[11. Container With Most Water](https://leetcode.com/problems/container-with-most-water/)
```
public int maxArea(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int max = 0;
    while(left < right)
    {
        max = Math.max(Math.min(height[left], height[right]) * (right - left), max);
        if(height[left]<height[right])
            left ++;
        else
            right --;
    }
    return max;
}
```

```
public int maxArea(int[] height) {
    // Math.min(h1, h2) * Math.abs(i1 - i2)
    int max = 0;
    for(int i = 0; i < height.length; i++)
        for(int j = 0; j < height.length; j ++)
        {
            max = Math.max(Math.min(height[i], height[j]) * Math.abs(i - j), max);
        }
    return max;
}
```

