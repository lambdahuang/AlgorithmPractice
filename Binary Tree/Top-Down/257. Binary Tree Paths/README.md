[257. Binary Tree Paths](https://leetcode.com/problems/binary-tree-paths/description/)

# Pre-order traversing

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new LinkedList();
        DFS(root, new StringBuilder(), ret);
        return ret;
    }
    public int DFS(TreeNode root, StringBuilder sb, List<String> ret)
    {
        if(root == null) return 0;
        int origLength = sb.length();
        if(origLength != 0) sb.append("->");
        sb.append(root.val);
        if(root.left == null && root.right == null)
            ret.add(sb.toString());
        else
        {
            DFS(root.left, sb, ret);
            DFS(root.right, sb, ret);   
        }
        sb.setLength(origLength);
        return 0;
    }
}
```
