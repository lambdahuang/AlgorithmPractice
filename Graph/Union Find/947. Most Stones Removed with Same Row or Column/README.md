[947. Most Stones Removed with Same Row or Column](https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/)

What the question asks is to remove the node from a connected graph until the last one.
A connected graph can always transform to a tree which roots from a single point.
Therefore, the max steps we could take is the number of total stones minus the number of dicrete components

So, here is the solution:


```
class Solution {
    public int[] pt;
    public int[] sz;
    public int removeStones(int[][] stones) {
        pt = new int[stones.length];
        sz = new int[stones.length];
        for(int i = 0; i < pt.length; i ++)
        {
            pt[i] = i;
            sz[i] = 1;
        }
        HashMap<Integer, List<Integer>> vm = new HashMap<>();
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        for(int i = 0; i < stones.length; i ++)
        {
            List<Integer> vl = vm.getOrDefault(stones[i][0], new LinkedList());
            List<Integer> hl = hm.getOrDefault(stones[i][1], new LinkedList());
            vl.add(i);
            hl.add(i);
            vm.put(stones[i][0], vl);
            hm.put(stones[i][1], hl);
        }
        for(Map.Entry<Integer, List<Integer>> en: vm.entrySet())
        {
            int tmp = -1;
            for(Integer i: en.getValue())
            {
                if(tmp == -1) tmp = i;
                else
                    union(tmp, i);
                //System.out.println(i);
            }
        }
        for(Map.Entry<Integer, List<Integer>> en: hm.entrySet())
        {
            int tmp = -1;
            for(Integer i: en.getValue())
            {
                if(tmp == -1) tmp = i;
                else
                    union(tmp, i);
                //System.out.println(i);
            }
        }
        HashSet<Integer> hs = new HashSet();
        for(int i = 0; i < pt.length;i ++)
        {
            hs.add(getRoot(pt[i]));
        }
            
        return pt.length - hs.size();
    }
    public int getRoot(int x)
    {
        while(pt[x] != x)
        {
            pt[x] = pt[pt[x]];
            x = pt[x];
        }
        return x;
    }
    
    public void union(int x, int y)
    {
        int xp = getRoot(x);
        int yp = getRoot(y);
        if(sz[xp] > sz[yp])
        {
            pt[yp] = pt[xp];
            sz[xp] += sz[yp];
        }
        else
        {
            pt[xp] = pt[yp];
            sz[yp] += sz[xp];
        }
    }
    public boolean find(int x, int y)
    {
        return getRoot(x) == getRoot(y);
    }
}
```
