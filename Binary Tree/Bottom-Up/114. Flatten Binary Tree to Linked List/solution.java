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
    public void flatten(TreeNode root) {
        Deque<TreeNode> dq = new ArrayDeque();
        TreeNode tmp = root;
        TreeNode pre = null;
        while(dq.size() != 0 || tmp != null)
        {
            TreeNode x = tmp;
            if(tmp == null) 
                tmp = dq.removeLast();
            else
            {
                
                if(tmp.right!=null) dq.addLast(tmp.right);
                if(pre != null) pre.right = tmp;
                TreeNode next = tmp.left;
                tmp.left = null;
                tmp = next;
            }
            if(x != null) pre = x;
        }
    }
}
