[143. Reorder List](https://leetcode.com/problems/reorder-list/description/)

You can use either Stack or Recursion to reverse the linkedlist.

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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        Stack<ListNode> st = new Stack();
        ListNode tmp = head;
        while(tmp != null)
        {
            st.push(tmp);
            tmp = tmp.next;
        }
        tmp = head;
        while(true)
        {
            ListNode tail = st.pop();
            ListNode orig = tmp.next;
            tmp.next = tail;
            if(tail == orig)
            {
                tail.next = null;
                break;
            }
            else if(orig.next == tail)
            {
                tail.next = orig;
                orig.next = null;
                break;
            }
            else
            {
                tail.next = orig;
                tmp = orig;
            }
        }
    }
}
```
