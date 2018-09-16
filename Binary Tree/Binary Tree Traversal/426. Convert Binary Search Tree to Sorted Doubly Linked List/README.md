[426. Convert Binary Search Tree to Sorted Doubly Linked List](https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/description/)

# Using Recursion (Post-order)

```
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    public Node treeToDoublyList(Node root) {
        if(root == null) return root;
        Node leftList = treeToDoublyList(root.left);
        Node rightList = treeToDoublyList(root.right);
        Node tmp = root;
        root.left = root;
        root.right = root;
        if(leftList != null) tmp = Merge(leftList, root);
        if(rightList != null) tmp = Merge(tmp, rightList);
        return tmp;
    }
    public Node Merge(Node A, Node B)
    {
        Node ATail = A.left;
        Node BTail = B.left;
        ATail.right = B;
        A.left = BTail;
        B.left = ATail;
        BTail.right = A;
        return A;
    }
}
```

# Using Iteration (In-order) 

While using the post-order recursion can efficiently solve this question but it is also an interesting challenge to use iteration redo it again.


```
class Solution {
    public Node treeToDoublyList(Node root) {
        Deque<Node> dq = new ArrayDeque();
        Node current = root;
        Node aligned = null;
        while(current != null || dq.size() != 0)
        {
            if(current != null)
            {
                dq.addFirst(current);
                current = current.left;
            }
            else
            {
                current = dq.removeFirst();
                Node right = current.right;
                if(aligned == null) 
                {
                    aligned = current;
                    aligned.left = aligned;
                    aligned.right = aligned;
                }
                else
                {
                    Node tail = aligned.left;
                    tail.right = current;
                    current.left = tail;
                    aligned.left = current;
                    current.right = aligned;
                }
                current = right;
            }
        }
        return aligned;
    }
}
```
