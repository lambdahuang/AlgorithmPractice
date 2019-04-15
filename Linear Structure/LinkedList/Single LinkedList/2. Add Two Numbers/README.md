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

4.15.2019
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
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        ListNode head = null;
        ListNode ret = null;
        ListNode fin = null;
        int addon = 0;
        int sum = 0;
        while(l1 != null || l2 != null || addon != 0) {
            if(l1 != null) {tmp1 = l1; fin = tmp1; l1 = l1.next;} else {tmp1 = null; fin = null;}
            if(l2 != null) {tmp2 = l2; l2 = l2.next; if(fin == null) fin = tmp2;} else {tmp2 = null;}
            
            if (tmp1 == null && tmp2 == null){
                fin = new ListNode(0);
                sum = addon;
            }
            else {
                sum = (tmp1!= null?tmp1.val:0) + (tmp2!= null?tmp2.val:0) + addon;
            }
            
            addon = sum/10;
            fin.val = sum % 10;
            if(ret== null) {ret = fin; head=ret;} else {ret.next = fin; ret = ret.next;}
        }
        return head;
    }
}
```
