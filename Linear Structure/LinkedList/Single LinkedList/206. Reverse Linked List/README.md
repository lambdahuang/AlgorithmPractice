[206. Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/submissions/)

```
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        Deque<ListNode> dq = new ArrayDeque<>();
        ListNode tmp = head;
        while(tmp!=null)
        {
            dq.addFirst(tmp);
            tmp=tmp.next;
        }
        ListNode dummyHead = new ListNode(0);
        tmp = dummyHead;
        
        while(dq.size() > 0)
        {
            ListNode t = dq.removeFirst();
            tmp.next = t;
            tmp = tmp.next;
        }
        tmp.next = null;
        return dummyHead.next;
    }
}
```
