This can be solved with DFS or BFS.

DFS solution
```
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        boolean[] map = new boolean[nums.length];
        List<List<Integer>> ret = new LinkedList();
        for(int i = 0; i < map.length; i ++) map[i] = true;
        DFS(ret, nums, map, 0);
        return ret;
    }
    public int DFS(List<List<Integer>> ret, int[] nums, boolean[] map, int index)
    {
        if(index > nums.length)
            return 0;
        ret.add(createList(nums, map));
        for(int i = index; i < nums.length; i++)
        {
            map[i] = false;
            DFS(ret, nums, map, i+1);
            map[i] = true;
        }
        return 0;
    }
    public List<Integer> createList(int[] nums, boolean[] map)
    {
        List<Integer> newLst = new LinkedList();
        for(int i = 0; i < nums.length; i ++)
            if(map[i]) newLst.add(nums[i]);
        return newLst;
    }
}
```
