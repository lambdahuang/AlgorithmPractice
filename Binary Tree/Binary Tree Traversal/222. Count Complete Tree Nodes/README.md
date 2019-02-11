[222. Count Complete Tree Nodes](https://leetcode.com/problems/count-complete-tree-nodes/)

# Vanilla solution (Tree Traversal)

```
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        Deque<TreeNode> dq = new ArrayDeque<>();
        int ret = 0;
        dq.addFirst(root);
        while(!dq.isEmpty())
        {
            ret += 1;
            TreeNode tmp = dq.removeLast();
            if(tmp.left != null) dq.addFirst(tmp.left);
            if(tmp.right != null) dq.addFirst(tmp.right);
        }
        return ret;
    }
}
```

# Linear Probing

Because the tree is complete binary tree, which means the tree only misses the node on the last level, we can linearly probe the number of nodes that were expected but missed on the bottom level.

```
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        TreeNode tmp = root;
        int maxLen = 1;
        while(tmp.left != null) {maxLen++; tmp = tmp.left;}
        ArrayDeque<TreeNode> dq = new ArrayDeque<>();
        ArrayDeque<Integer> dqDepth = new ArrayDeque<>();

        int len = 1;
        int offset = 0;
        tmp = root;
        while(true){
            if(tmp != null && len == maxLen)
            {
                break;
            }
            else if(tmp != null) 
            {
                dq.addFirst(tmp);
                dqDepth.addFirst(len);
                len++;
                tmp = tmp.right;

            }
            else if(!dq.isEmpty()) 
            { 
                tmp = dq.removeFirst().left;
                len = dqDepth.removeFirst() + 1;
                offset ++;
            }
        }
        return (int)Math.pow(2, maxLen) - 1 - offset;
    }
}
```
