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
