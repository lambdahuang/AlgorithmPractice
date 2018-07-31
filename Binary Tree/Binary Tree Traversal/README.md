[173. Binary Search Tree Iterator](https://leetcode.com/problems/binary-search-tree-iterator/description/)

My strategy is using in-order traversal to put all TreeNode into a queue.

```
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    Queue<TreeNode> q = new LinkedList();
    public void DFS(TreeNode root)
    {
        if(root == null) return;
        DFS(root.left);
        q.offer(root);
        DFS(root.right);
    }
    public BSTIterator(TreeNode root) {
        DFS(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !q.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        return q.poll().val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
```
