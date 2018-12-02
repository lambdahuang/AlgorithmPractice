[102. Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/)

This question does not deserve a medium-level.

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayDeque<TreeNode> dq = new ArrayDeque<>();
        List<List<Integer>> ans = new LinkedList();
        if(root == null) return ans;
        dq.addFirst(root);
        while(!dq.isEmpty())
        {
            List<Integer> cur = new LinkedList();
            int qSize = dq.size();
            for(int i = 0; i < qSize; i ++)
            {
                TreeNode tmp = dq.removeLast();
                cur.add(tmp.val);
                if(tmp.left != null) dq.addFirst(tmp.left);
                if(tmp.right != null) dq.addFirst(tmp.right);
            }
            ans.add(cur);
        }
        return ans;
    }
}
```
