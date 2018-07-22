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
