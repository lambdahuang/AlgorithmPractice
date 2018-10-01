[199. Binary Tree Right Side View](https://leetcode.com/problems/binary-tree-right-side-view/)

# BFS
The BFS solution is pretty simple, you iterate each level of nodes and record the left most node.

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
```

# DFS
The DFS solution would be a little bit tricky, you access right node before left node.
Meanwhile, you may pass an variable of level and compare it with List size at the begining of the recursion, which would give you the signal of first element of each level. 
each level.

```
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if( root == null ) return res;
        helper(root,res,0);
        return res;
    }
    
    private void helper(TreeNode node, List<Integer> res , int level){
        if( node == null ) return;
        if( res.size() == level ){
            res.add(node.val);
        }
        helper(node.right,res,level+1);
        helper(node.left,res,level+1);
    }
}
```
