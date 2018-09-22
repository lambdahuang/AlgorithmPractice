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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayDeque<TreeNode> adq = new ArrayDeque();
        ArrayDeque<TreeNode> bdq = new ArrayDeque();
        DFS(root, p, adq);
        DFS(root, q, bdq);
        TreeNode ret = null;
        while(!adq.isEmpty() && !bdq.isEmpty())
        {
            TreeNode tmp1 = adq.pollFirst();
            TreeNode tmp2 = bdq.pollFirst();
            if(tmp1 == tmp2) ret = tmp1; else break;
        }
        return ret;
    }
    public boolean DFS(TreeNode root, TreeNode target, ArrayDeque lst)
    {
        if(root == null) return false;
        lst.addLast(root);
        if(root == target) return true;
        else if(DFS(root.left, target, lst) || DFS(root.right, target, lst))
        {
            return true;
        }
        else
        {
            lst.removeLast(); // remove root;
            return false;
        }
    }
}
