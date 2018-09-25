[721. Accounts Merge](https://leetcode.com/problems/accounts-merge/description/)

This is not the best practice but the idea is the same which is using the Union Find to dynamic connect discrete component.

```
class Solution {
    int[] id;
    int[] sz;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // System.out.println(":-)");
        List<List<String>> ret = new LinkedList();
        id = new int[accounts.size()];
        sz = new int[accounts.size()];
        for(int i = 0; i < id.length; i ++) id[i] = i;
        HashSet<String>[] hsL = new HashSet[accounts.size()];
        for(int i = 0; i < accounts.size(); i++)
        {
            hsL[i] = new HashSet<String>();
            List<String> lst = accounts.get(i);
            for(int j = 1; j < lst.size(); j ++)
            {
                // System.out.println(lst.get(j));
                hsL[i].add(lst.get(j));
                for(int k = 0; k < i; k ++)
                    if(hsL[k].contains(lst.get(j))) {union(i, k);}
            }
        }
        HashMap<Integer, HashSet<String>> hm = new HashMap();
        for(int i = 0; i < accounts.size(); i ++)
        {
            List<String> ori = accounts.get(i);
            HashSet<String> lst = null;
            // System.out.print(i + " " + id[i] + " - ");
            int root = getRoot(id[i]);
            if(hm.containsKey(root))
                lst = hm.get(root);
            else 
            {
                lst = new HashSet();
                hm.put(root, lst);
            }
            for(int j = 1; j < ori.size(); j++)
                lst.add(ori.get(j));
        }
        for(Map.Entry<Integer, HashSet<String>> em : hm.entrySet())
        {
            List<String> lst = new LinkedList(em.getValue());
            Collections.sort(lst);
            lst.add(0, accounts.get(em.getKey()).get(0));
            ret.add(lst);
        }
        return ret;
    }
    public int getRoot(int x)
    {
        int tmp = x;
        while(id[tmp]!=tmp)
        {
            id[tmp] = id[id[tmp]];
            tmp = id[tmp];
        }
        return tmp;
    }
    public boolean find(int x, int y)
    {
        if(getRoot(x) == getRoot(y)) return true;
        return false;
    }
    public void union(int x, int y)
    {
        int rootX = getRoot(x);
        int rootY = getRoot(y);
        if(sz[x] > sz[y])
        {
            id[rootY] = rootX;
            sz[rootX] += sz[rootY];
        }
        else
        {
            id[rootX] = rootY;
            sz[rootY] += sz[rootX];
        }
    }
}
```
