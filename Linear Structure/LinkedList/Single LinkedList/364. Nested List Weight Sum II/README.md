[364. Nested List Weight Sum II](https://leetcode.com/problems/nested-list-weight-sum-ii/description/)

The challenge would be how to solve this question elegantly.

```
class Solution {
    List<Integer> roofList = new LinkedList();
    List<Integer> roofFactor = new LinkedList();
    int maxDepth = 0;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if(nestedList == null) return 0;
        DFS(nestedList, 1);
        Integer[] roofListArray = roofList.toArray(new Integer[roofList.size()]);
        Integer[] roofFactorArray = roofFactor.toArray(new Integer[roofFactor.size()]);
        int sum = 0;
        for(int i = 0; i < roofListArray.length; i ++)
        {
            sum += roofListArray[i] * (maxDepth - roofFactorArray[i] + 1);
        }
        return sum;
    }
    
    public int DFS(List<NestedInteger> nestedList, int depth)
    {
        maxDepth = Math.max(maxDepth, depth);
        for(NestedInteger ni : nestedList)
        {
            if(ni.isInteger()) 
            {
                roofList.add(ni.getInteger());
                roofFactor.add(depth);
            }
            else
            {
                DFS(ni.getList(), depth + 1);
            }
        }
        return 0;
    }
    
}
```
