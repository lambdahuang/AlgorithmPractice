/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode front = dummy;
        ListNode rear = head;
        while(rear != null)
        {
            if(rear.val == val)
            {
                front.next = rear.next;
                rear = rear.next;
            }
            else
            {
                front = rear;
                rear = rear.next;
            }
        }
        return dummy.next;
    }
}
