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
    public boolean isValidBST(TreeNode root) {
        return DFS(root, (long)(Integer.MIN_VALUE) - 1, (long)(Integer.MAX_VALUE) + 1);
    }
    public boolean DFS(TreeNode root, long min, long max)
    {
        if(root == null) return true;
        if(root.val >= max || root.val <= min) return false;
        if(DFS(root.left, min, root.val) &&
           DFS(root.right, root.val, max))
            return true;
        else
            return false;
    }
}
