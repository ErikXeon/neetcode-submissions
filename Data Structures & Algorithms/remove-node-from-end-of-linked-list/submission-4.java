/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        if(head.next == null) return null;
        
        for(int i = 0; i < n - 1; i++) {
            slow = slow.next;
        }

        while(slow.next != null && slow.next.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        fast.next = fast.next.next;

        return dummy.next;
    }
}