Two approach you might take:

1. Once you get the NestedInteger, you immediately process it to a list integer using DFS.

2. You can dynamically parse the nested data structure to a list integer whenever it is requested.

Mine is the first one. 

Second solution would be a little bit complicated. you might use a Stack to keep tracking on your position once you dive into the unlimited hole of nested structure. In solving this question, you may have the answer for what benefit python **yield** method would give to you :-P


```
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    Queue<Integer> q = new LinkedList();
    public NestedIterator(List<NestedInteger> nestedList) {
        for(NestedInteger i : nestedList) DFS(i);
    }
    public void DFS(NestedInteger root)
    {
        if(root == null) return;
        if(root.isInteger()) q.offer(root.getInteger());
        else
        {
            List<NestedInteger> lst = root.getList();
            for(NestedInteger i: lst) DFS(i);
        }
        return;
    }

    @Override
    public Integer next() {
        return q.poll();
    }

    @Override
    public boolean hasNext() {
        return !q.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
```
