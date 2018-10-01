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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new LinkedList();
        if(root == null) return ret;
        Deque<TreeNode> dq = new ArrayDeque<TreeNode>();
        dq.addFirst(root);
        while(!dq.isEmpty())
        {
            int qSize = dq.size();
            for(int i = 0; i < qSize; i ++)
            {
                TreeNode tmp = dq.removeLast();
                if(tmp.left != null) dq.addFirst(tmp.left);
                if(tmp.right != null) dq.addFirst(tmp.right);
                if(i == qSize -1) ret.add(tmp.val);
            }
        }
        return ret;
    }
}
