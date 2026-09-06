
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null;
        ListNode curr = slow.next;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        slow.next = null;
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        ListNode p1 = head;
        ListNode p2 = prev;

        while(p1 != null && p2 != null) {
            current.next = p1;
            p1 = p1.next;
            current = current.next;
            current.next = p2;
            p2 = p2.next;
            current = current.next;
        }
        if(p1 != null) current.next = p1;
        if(p2 != null) current.next = p2;
    }
}                                                    