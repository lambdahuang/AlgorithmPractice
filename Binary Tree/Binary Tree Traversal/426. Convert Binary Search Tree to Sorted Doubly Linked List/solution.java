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
