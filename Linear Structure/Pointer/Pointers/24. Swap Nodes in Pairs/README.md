[24. Swap Nodes in Pairs](https://leetcode.com/problems/swap-nodes-in-pairs/)

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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode tmp = dummyHead;
        ListNode tail = head.next.next; // means it has to have more than 2 nodes
        while(true)
        {
            if(tmp == null || tmp.next == null || tmp.next.next == null) break;
            ListNode left = tmp.next;
            ListNode right = left.next;
            tail = right.next;
            tmp.next = right;
            right.next = left;
            left.next = tail;
            
            tmp = left;
        }
        return dummyHead.next;
        
    }
}
```
