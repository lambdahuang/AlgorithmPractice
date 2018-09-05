[339. Nested List Weight Sum](https://leetcode.com/problems/nested-list-weight-sum/description/)

```
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null) return 0;
        DFS(nestedList, 1);
        return sum;
    }
    int sum = 0;
    public int DFS(List<NestedInteger> nl, int depth)
    {
        for(NestedInteger ni: nl)
        {
            if(ni.isInteger()) sum += ni.getInteger() * depth;
            else DFS(ni.getList(), depth + 1);
        }
        return 0;
    }
}
```
