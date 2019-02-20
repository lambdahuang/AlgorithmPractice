[135. Candy](https://leetcode.com/problems/candy/)

The minimum number of candies for each child is decided by the number of a series of children who are on the left or right side and aligned from near to far toward the target child and have ratings are always lower than the previous child.

```
class Solution {
    public int candy(int[] ratings) {
        int[] mapLeftLowerValue = new int[ratings.length];
        int tmp = Integer.MAX_VALUE;
        for(int i = 0; i < ratings.length; i ++)
        {
            if(ratings[i] > tmp) 
                mapLeftLowerValue[i] = mapLeftLowerValue[i-1] + 1; 
            else mapLeftLowerValue[i] = 0;
            tmp = ratings[i];
        }
        tmp = Integer.MAX_VALUE;
        int[] mapRightLowerValue = new int[ratings.length];
        for(int i = ratings.length-1; i >= 0; i --)
        {
            if(ratings[i] > tmp) 
                mapRightLowerValue[i] = mapRightLowerValue[i+1] + 1; 
            else mapRightLowerValue[i] = 0;
            tmp = ratings[i];
        }
        int sum = 0;
        for(int i = 0; i < ratings.length; i ++)
        {
            sum += Math.max(mapRightLowerValue[i], mapLeftLowerValue[i]) + 1;
        }
        return sum;
    }
}
```

2019.2.20

Greedy approach, we make sure that each child give the minimum candies based on his left-side chird and right-side child.

```
class Solution {
    public int candy(int[] ratings) {
        int[] map = new int[ratings.length];
        map[0] = 1;
        for(int i = 1; i < ratings.length; i ++)
        {
            if(ratings[i] > ratings[i-1])
                map[i] = map[i-1] + 1;
            else
                map[i] = 1;
        }
        for(int i = ratings.length-2; i >=0 ; i --)
        {
            if(ratings[i] > ratings[i+1])
                map[i] = Math.max(map[i+1] + 1, map[i]);
        }
        int sum = 0;
        for(int i = 0; i < map.length;i  ++)
            sum += map[i];
        return sum;
    }
}
```
