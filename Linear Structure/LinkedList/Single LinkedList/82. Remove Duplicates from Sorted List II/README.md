
An element that appears once in the list satisfies following codition:

1. This element must have different value than her predecessor.

1. This element must have differnet value than her successor.

We append element to the new list only if previous two condition is satisfied.

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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode fakeHead = new ListNode(0);
        ListNode safe = fakeHead;
        ListNode previous = fakeHead;
        ListNode current = head;
        while(current != null)
        {
            if((previous == fakeHead || previous.val != current.val) &&
               (current.next == null || current.next.val != current.val))
            {
                safe.next = current;
                safe = current;
            }
            previous = current;
            current = current.next;
        }
        safe.next = null;
        return fakeHead.next;
    }
}
```
