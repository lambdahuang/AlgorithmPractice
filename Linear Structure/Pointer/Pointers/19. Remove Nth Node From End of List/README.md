[19. Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)

There are two solutions:

1. You may use the stack to give you the capability to access the ListNode in the direction from tail to head.

2. You may use fast-slow pointers to solve the question in single run.

```
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ArrayDeque<ListNode> dq = new ArrayDeque<ListNode>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        dq.addFirst(dummy);
        for(ListNode tmp = head; tmp != null; tmp=tmp.next) {System.out.println(tmp.val); dq.addFirst(tmp);}
        ListNode target = null;
        for(int i = 0; i < n; i++)
            target = dq.removeFirst();
        ListNode nex = dq.removeFirst();
        nex.next = target.next;
        return dummy.next;
    }
```

```
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        for(int i = 0; i < n; i++) fast = fast.next;
        ListNode slow = dummy;
        for(slow = dummy; fast.next != null; slow=slow.next,fast=fast.next);
        slow.next = slow.next.next;
        return dummy.next;
    }
```

