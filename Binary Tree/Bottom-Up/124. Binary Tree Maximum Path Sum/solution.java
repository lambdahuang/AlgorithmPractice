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
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        int[] ret = DFS(root, root.val);
        System.out.println(ret[0] + " " + ret[1] + " " + ret[2]);
        return ret[2] < 0? ret[2]: ret[0];
    }
    public int[] DFS(TreeNode root, int curBestChoice)
    {
        int[] ret = new int[3]; //ret[0] max path && ret[1] max single path
        ret[2] = curBestChoice;
        if(root == null) return ret;
        curBestChoice = Math.max(root.val, curBestChoice);
        int[] left = DFS(root.left, curBestChoice);
        int[] right = DFS(root.right, curBestChoice);
        ret[0] = Math.max(left[0], right[0]);
        ret[0] = Math.max(ret[0], left[1] + right[1] + root.val);
        ret[1] = Math.max(left[1], right[1]) + root.val;
        ret[1] = Math.max(0, ret[1]); // you can just give up the entire sub tree
        ret[2] = Math.max(left[2], right[2]);
        return ret;
    }
}
