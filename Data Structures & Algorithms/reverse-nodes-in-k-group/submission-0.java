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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        ListNode prevGroupTail = dummy;
        ListNode groupStart = head;

        while(true) {
            ListNode iterator = groupStart;
            int counter = 0;
            while(iterator != null && counter < k) {
                counter++;
                iterator = iterator.next;
            }
            if(counter != k) {
                break;
            }
            int coun = 0;
            ListNode prev = null;
            ListNode curr = groupStart;
            while(curr != null && coun < k) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                coun++;
            }
            prevGroupTail.next = prev;
            groupStart.next = curr;
            prevGroupTail = groupStart;
            groupStart = curr;
        }
        return dummy.next;
    }
}
