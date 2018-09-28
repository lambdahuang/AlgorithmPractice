[51. N-Queens](https://leetcode.com/problems/n-queens/)

```
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ret = new LinkedList<>();
        List<String> candidates = new ArrayList<>();
        for(int i = 0; i < n; i++) candidates.add(rowPrinter(i, n));
        DFS(0,
            n,
            new HashSet<Integer>(),
            new HashSet<Integer>(),
            new HashSet<Integer>(),
            candidates,
            new ArrayList<>(n),
            ret);
        return ret;
    }
    public void DFS(
        int index,
        int n,
        HashSet<Integer> column_hs,
        HashSet<Integer> left_diagnal_hs,
        HashSet<Integer> right_diagnal_hs,
        List<String> candidates,
        List<String> lst,
        List<List<String>> ret)
    {
        if(index == n) 
        {
            
            List<String> newlist = new ArrayList<>(lst.size());
            for(String x : lst) newlist.add(x);
            ret.add(newlist);
            return;
        }
        for(int i = 0; i < n; i++)
        {
            int left_diagnal = i - index;
            int right_diagnal = index + i;
            if(!left_diagnal_hs.contains(left_diagnal) &&
               !right_diagnal_hs.contains(right_diagnal) &&
               !column_hs.contains(i))
            {
                column_hs.add(i);
                right_diagnal_hs.add(right_diagnal);
                left_diagnal_hs.add(left_diagnal);
                
                lst.add(candidates.get(i));
                DFS(index + 1, n, column_hs, left_diagnal_hs, right_diagnal_hs, candidates, lst, ret);
                lst.remove(lst.size() - 1);
                
                column_hs.remove(i);
                right_diagnal_hs.remove(right_diagnal);
                left_diagnal_hs.remove(left_diagnal);
            }
        }
        return;
    }
    public String rowPrinter(int x, int n)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++)
        {
            if(i != x)
                sb.append(".");
            else
                sb.append("Q");
        }
        return sb.toString();
    }
}
```
