# [1110. Delete Nodes And Return Forest](https://leetcode.com/problems/delete-nodes-and-return-forest/)

The solution is not hard, but one thing needs to be careful is that, after recursion is done, you need to check whether the root is removed or not, if it is not, you should add it to the result.

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashSet<Integer> to_delete_set;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        to_delete_set = new HashSet();
        for (int i : to_delete)
            to_delete_set.add(i);
        List<TreeNode> ret = new LinkedList();
        root = recur(root, ret);
        if(root != null) ret.add(root);
        return ret;
    }

    public TreeNode recur(TreeNode root, List<TreeNode> ret) {
        if (root == null) return null;

        root.left = recur(root.left, ret);
        root.right = recur(root.right, ret);

        if (to_delete_set.contains(root.val)) {
            if (root.left != null) ret.add(root.left);
            if (root.right != null) ret.add(root.right);
            return null;
        } else {
            return root;
        }

    }
}
```
