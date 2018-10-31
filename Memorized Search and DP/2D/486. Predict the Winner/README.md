[486. Predict the Winner](https://leetcode.com/problems/predict-the-winner/)

What a classical question, I first meet this question on the class of Analysis of Algorithm? After that, I obsessed by the Game Theory.

```
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        //System.out.println("-----------");
        int map[][] = new int[nums.length][nums.length];
        int sum = 0;
        for(int i = 0; i < nums.length; i ++)
        {
            map[i][i] = nums[i];
            if(i+1< nums.length)map[i][i+1] = Math.max(nums[i], nums[i+1]);
            sum += nums[i];
        }
        for(int n = 2; n < nums.length; n ++)
        {
            for(int i = 0; i < nums.length - n ; i++)
            {
                int j = i + n;
                map[i][j] = Math.max(
                    nums[i] + Math.min(map[i+1][j-1], map[i+2][j]),
                    nums[j] + Math.min(map[i+1][j-1], map[i][j-2])
                );
                //System.out.println(i + ", " + j + " " +  map[i][j]);
            }
            
        }
        
        return sum <= (2 * map[0][nums.length-1]);
        
    }
}
```
