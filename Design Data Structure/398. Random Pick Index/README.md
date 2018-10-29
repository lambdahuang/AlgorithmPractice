[398. Random Pick Index](https://leetcode.com/problems/random-pick-index/)

```
class Solution {
    HashMap<Integer, List<Integer>> hm = new HashMap();
    public Solution(int[] nums) {
        for(int i = 0; i < nums.length; i ++)
        {
            int x = nums[i];
            if(hm.containsKey(x))
            {
                hm.get(x).add(i);
            }
            else
            {
                List<Integer> lst = new ArrayList();
                lst.add(i);
                hm.put(x, lst);
            }
        }
    }
    
    public int pick(int target) {
        Random rand = new Random();
        List<Integer> arr = hm.get(target);
        int randint = rand.nextInt(arr.size());
        return arr.get(randint);
    }
}

```
