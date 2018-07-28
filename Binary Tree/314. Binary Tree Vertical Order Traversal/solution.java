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
