[298. Binary Tree Longest Consecutive Sequence](https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/)

You need to decide a place to update the status before going into the next level in the recursion.
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
    int max = 0;
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;v
        DFS(root, 0, root.val);
        return max;
    }
    public void DFS(TreeNode root, int depth, int prev)
    {
        if(root == null) return;
        if(root.val == prev + 1) depth+=1; else depth = 1;
        max = Math.max(depth, max);
        
        DFS(root.left, depth, root.val);
        DFS(root.right, depth, root.val);
        return;
    }
}
```
