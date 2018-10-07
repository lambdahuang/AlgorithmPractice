[2. Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int tmp = 0;
        ListNode leftPointer = l1;
        ListNode rightPointer = l2;
        ListNode header = new ListNode(0);
        ListNode current = header;
        while(l1 != null || l2 != null || tmp != 0)
        {
            if(l1 != null) {tmp += l1.val; l1 = l1.next;}
            if(l2 != null) {tmp += l2.val; l2 = l2.next;}
            ListNode newNode = new ListNode(tmp % 10);
            current.next = newNode;
            tmp = tmp >= 10? 1:0;
            current = current.next;
        }
        return header.next;
    }
}
```
