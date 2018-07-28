[543. Diameter of Binary Tree](https://leetcode.com/problems/diameter-of-binary-tree/description/)

It's a straight-forward solution.

Using DFS solution allows us to break up the tree to a series of sub-tree accessed in the bottom-up order.

Time complexity O(n): n is number of nodes, each node would be accessed once.


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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        DFS(root);
        return max - 1;
    }
    
    public int DFS(TreeNode root)
    {
        if(root == null) return 0;
        int leftMax = DFS(root.left);
        int rightMax = DFS(root.right);
        max = Math.max(leftMax + rightMax + 1, max);
        return Math.max(leftMax, rightMax) + 1;
    }
}
```
