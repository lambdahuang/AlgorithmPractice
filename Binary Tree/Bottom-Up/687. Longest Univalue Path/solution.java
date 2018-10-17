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
    int max = 1;
    public int longestUnivaluePath(TreeNode root) {
        DFS(root);
        return max-1;
    }
    public int[] DFS(TreeNode root)
    {
        int[] ans = new int[2]; // ans[0] <- root.val, ans[1] <- max length
        if(root == null) return ans;
        ans[0] = root.val;
        int[] ans_left = DFS(root.left);
        int[] ans_right = DFS(root.right);
        int max_length = 1;
        max_length += ((ans_left[0]==root.val)?ans_left[1]:0);
        max_length += ((ans_right[0]==root.val)?ans_right[1]:0);
        max = Math.max(max, max_length);
        ans[1] = 1+ Math.max(((ans_right[0]==root.val)?ans_right[1]:0), ((ans_left[0]==root.val)?ans_left[1]:0));
        return ans;
    }
}
