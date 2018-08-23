First attempt: (26ms) Too many unnecessary code.

```
class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        HashMap<Integer, List<Integer>> hm = new HashMap();
        List<Integer> init = new LinkedList();
        init.add(0);
        hm.put(0, init);
        for(int i = 0; i < nums.length; i ++)
        {
            sum[i + 1] = sum[i] + nums[i];
            List<Integer> lst = hm.getOrDefault(sum[i + 1], new LinkedList());
            lst.add(i+1);
            hm.put(sum[i+1], lst);
        }
        int ret = 0;
        for(int i = 0; i < sum.length; i ++)
        {
            if(hm.containsKey(sum[i] - k))
            {
                List<Integer> lst = hm.get(sum[i] - k);
                for(int j: lst)
                {
                    if(j < i) ret ++;
                }
            }
        }
        return ret;
        
    }
}
```

Second attempt: 
Removed the redundency.
```
class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int ret = 0;
        HashMap<Integer, Integer> hm = new HashMap();
        hm.put(0, 1);
        for(int i = 0; i < nums.length; i ++)
        {
            sum += nums[i];
            if(hm.containsKey(sum - k))
                ret += hm.get(sum - k);
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }
        return ret;
    }
}
```
