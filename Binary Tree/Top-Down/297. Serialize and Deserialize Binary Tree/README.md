It's an quite interesting question.
This reminds me the days when I took advanced data structure back to 2016.
Professor Meral asks us to use an array to store a tree structure.


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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        Deque<TreeNode> dq = new ArrayDeque<>();
        Deque<Integer> dqindex = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        dq.addLast(root);
        dqindex.addLast(1);
        while(!dq.isEmpty())
        {
            TreeNode t = dq.removeFirst();
            int id = dqindex.removeFirst();
            sb.append(id); sb.append(",");
            sb.append(t.val); sb.append(",");
            if(t.left!=null) {dq.addLast(t.left); dqindex.addLast(id * 2);}
            if(t.right!=null) {dq.addLast(t.right); dqindex.addLast(id * 2 + 1);}
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        String[] arr = data.split(",");
        Deque<TreeNode> dq = new ArrayDeque<>();
        HashMap<Integer, TreeNode> hm = new HashMap<>();
        for(int i = 0; i < arr.length; i+=2)
        {
            int id = Integer.valueOf(arr[i]);
            TreeNode tmp = genNode(arr[i+1]);
            if(id != 1) 
            {
                TreeNode parent = hm.get(id / 2);
                if(id % 2 == 1) parent.right = tmp; else parent.left =tmp;
            }
            hm.put(id, tmp);
        }
        return hm.get(1);
    }
    public TreeNode genNode(String s)
    {
        if(s.equals("n"))
            return null;
        else
            return new TreeNode(Integer.valueOf(s));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
```

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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        Deque<TreeNode> dq = new ArrayDeque<>();
        Deque<Integer> dqpid = new ArrayDeque<>();
        Deque<Integer> dqside = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        dq.addLast(root);
        dqpid.addLast(0);
        dqside.addLast(0);
        int id = 0;
        while(!dq.isEmpty())
        {
            TreeNode t = dq.removeFirst();
            int side = dqside.removeFirst();
            int pid = dqpid.removeFirst();
            sb.append(id); sb.append(",");
            sb.append(pid); sb.append(",");
            sb.append(side); sb.append(",");
            sb.append(t.val); sb.append(",");
            if(t.left!=null) {dq.addLast(t.left); dqpid.addLast(id);dqside.addLast(1);}
            if(t.right!=null) {dq.addLast(t.right); dqpid.addLast(id);dqside.addLast(2);}
            id ++;
        }
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        String[] arr = data.split(",");
        Deque<TreeNode> dq = new ArrayDeque<>();
        HashMap<Integer, TreeNode> hm = new HashMap<>();
        for(int i = 0; i < arr.length; i+=4)
        {
            int id = Integer.valueOf(arr[i]);
            int pid = Integer.valueOf(arr[i+1]);
            int side = Integer.valueOf(arr[i+2]);
            TreeNode tmp = genNode(arr[i+3]);
            if(id != 0) 
            {
                TreeNode parent = hm.get(pid);
                if(side != 1) parent.right = tmp; else parent.left =tmp;
            }
            hm.put(id, tmp);
        }
        return hm.get(0);
    }
    public TreeNode genNode(String s)
    {
        if(s.equals("n"))
            return null;
        else
            return new TreeNode(Integer.valueOf(s));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
```
