[15. 3Sum](https://leetcode.com/problems/3sum/description/)

The question didn't ask to maintain any order of original array, so we sort it first.

Sorting is always the best way to reduce duplicate processing on the array.

Then, we could use the two-layer iterations to solve this question
where the outer-layer to chose one number as the pivot point and the inner-layer iteration utilize two pointers to find the rest of two numbers in O(n) time.

To prune duplicate cases, we let the program probe and move to the next different number whenever we move our pointer forward.

```
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new LinkedList();
        if(nums == null || nums.length < 3) return ret;
        Arrays.sort(nums);
        int tmp = nums[0] + 1;
        for(int i = 0; i < nums.length - 2; i++)
        {
            if(nums[i] == tmp) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right)
            {
                int sum = nums[left] + nums[right] + nums[i];
                if(sum == 0) {
                    List<Integer> res = new LinkedList();
                    res.add(nums[i]);
                    res.add(nums[left]);
                    res.add(nums[right]);
                    ret.add(res);
                    int curLeft = left;
                    int curRight = right;
                    while(left < right && nums[left] == nums[curLeft])left ++;
                    
                }
                else if(sum < 0) left ++;
                else right --;
            }
            tmp = nums[i];
        }
        
        return ret;
    }
}
```

Also, there is another method where we can solve this question by using the HashSet to check if duplication happens.

```
class Solution {
    public List<List<Integer>> threeSum(int[] n) {
        Set<List<Integer>> res = new HashSet<>();
        if( n == null || n.length == 0) return new ArrayList<>();
        Arrays.sort(n);
        for(int i = 0 ; i < n.length - 2 ; i++){
            if ( i - 1 >= 0  && n[i] == n[i-1]) continue;
            Set<Integer> set = new HashSet();
            int target = 0 - n[i];
            int start = i + 1, end = n.length - 1;
            for( int j = start ; j <= end ; j++){
                if( set.contains(target-n[j])){
                    res.add(Arrays.asList(n[i],target-n[j],n[j]));
                } else {
                    set.add(n[j]);
                }
            }
        }
        return new ArrayList<>(res);
    }
}
```
