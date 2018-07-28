[314. Binary Tree Vertical Order Traversal](https://leetcode.com/problems/binary-tree-vertical-order-traversal/description/)

As mentioned in the topic, the vertical order traversal of a tree is always done by BFS.

Besides the BFS, we also need to remember the column position of each node.

Based on the example, it is not hard to find that the logic behind this is that the position of left child = position of parent - 1,
also the position of right child = position of parent + 1.

Therefore, we can use two queues to keep tracking on the positions and nodes.

To map the node in the same column to a single list, we can utilize hasmap for its O(1) time complexity looking up capability.



```
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList();
        if(root == null)
            return ret;
        HashMap<Integer, List<Integer>> hm = new HashMap();
        Queue<TreeNode> qNode = new LinkedList();
        Queue<Integer> qPos = new LinkedList();
        qNode.add(root);
        qPos.add(0);
        int min = 0;
        int max = 0;
        while(!qNode.isEmpty())
        {
            int qLen = qNode.size();
            for(int i = 0; i < qLen; i ++)
            {
                int pos = qPos.poll();
                TreeNode n = qNode.poll();
                // append current node
                List<Integer> col = hm.getOrDefault(pos, new LinkedList());
                col.add(n.val);
                hm.put(pos, col);
                
                min = Math.min(min, pos);
                max = Math.max(max, pos);
                
                if(n.left != null)
                {
                    qNode.add(n.left);
                    qPos.add(pos - 1);
                }
                if(n.right != null)
                {
                    qNode.add(n.right);
                    qPos.add(pos + 1);
                }
            }
        }
        //System.out.print(min + "," + max);
        for(int i = min; i <= max; i++)
        {
            List lst = hm.getOrDefault(i, null);
            if(lst != null) ret.add(lst);
        }
        return ret;
    }
}
```
