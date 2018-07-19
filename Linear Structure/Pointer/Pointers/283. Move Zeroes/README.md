
This is a bad practice sample

Time Complexity: O(n^2)

Space Complexity: O(1)

```
class Solution {
    public void moveZeroes(int[] nums) {
        int l = 0;
        int i = 0;
        while(i < nums.length - l)
        {
            if(nums[i] == 0)
            {
                for(int j = i + 1; j < nums.length;j ++)
                    nums[j - 1] = nums[j];
                nums[nums.length-1] = 0;
                l++;
            }
            else
                i++;
        }
        return;
    }
}
```


This solution comes with a map to record the number of 0 in the array before a certain position.

Time Complexity: O(n)

Space Complexity: O(n)

```
class Solution {
    public void moveZeroes(int[] nums) {
        int[]map = new int[nums.length + 1];
        for(int i = 1; i <= nums.length; i++)
            if(nums[i-1] == 0)
                map[i] = 1 + map[i - 1];
            else
                map[i] = map[i-1];

        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i]!=0)
                nums[i-map[i]] = nums[i];
        }
        for(int i = nums.length - map[map.length - 1]; i < nums.length; i ++ )
            nums[i]=0;
        return;
    }
}
```

Two Pointers

Time Complexity: O(n)

Space Complexity: O(1)

Quite elegant solution.

Some notices: 
From my perspective the most elegant part in this code is that we use an element swaping intead of single-direction of dumping the non-zero element to the non-zeor pointer and assign the old position a zero.
The reason we can't do that is because it can't handle the case of that all numbers are non-zero! Swaping is forgiving for most of cases.

E.g., you can swap on the same element which won't change anything, and also this is what we do for the first element of the array.


```
class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for(int i = 0; i < nums.length; i ++)
        {
            if(nums[i] != 0)
            {
                int tmp = nums[index];
                nums[index ++] = nums[i];
                nums[i] = tmp;
            }
        }
    }
}
```
