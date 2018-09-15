class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i ++)
            sum[i+1] = sum[i] + nums[i];
        int[] p = new int[nums.length];
        for(int i = 0; i < nums.length - k + 1; i ++)
        {
            p[i] = sum[i + k] - sum[i];
        }
        int[][] map = new int[4][nums.length];
        int[][] his = new int[4][nums.length];
        for(int j = 0; j < 3 ; j++)
        {
            int[] updateMap = map[j + 1];
            int[] previMap = map[j];
            int[] historyMap = his[j + 1];
            for(int i = nums.length - k * (j + 1); i >= 0;  i --)
            {
                
                updateMap[i] = p[i] + (i + k < nums.length?previMap[i + k]:0);
                historyMap[i] = i;
                if(i + 1 < nums.length && updateMap[i] < updateMap[i + 1])
                {
                    updateMap[i] = updateMap[i + 1];
                    historyMap[i] = historyMap[i + 1];
                }
            }
            
        }

        int[] ret = new int[3];
        ret[0] = his[3][0];
        ret[1] = his[2][ret[0] + k];
        ret[2] = his[1][ret[1] + k];
        
        return ret;
        
    }
}
