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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        ListNode p1 = l1;
        ListNode p2 = l2;
        int carry = 0;
        int summ = 0;
        while(p1 != null || p2 != null) {
            if(p1 == null) {
                summ = (0 + p2.val + carry) % 10;
                carry = (0 + p2.val + carry) /10;
            }
            else if(p2 == null) {
                summ = (0 + p1.val + carry) % 10;
                carry = (p1.val + 0 + carry) /10;
            }
            else {
                summ = (p1.val + p2.val + carry) % 10;
                carry = (p1.val + p2.val + carry) /10;
            }
            current.next = new ListNode(summ);
            current = current.next;
            if(p1 != null) {
                p1 = p1.next;
            }
            if(p2 != null) {
                p2 = p2.next;
            }
        }
        if(carry != 0) current.next = new ListNode(carry);
        return dummy.next;
    }
}
