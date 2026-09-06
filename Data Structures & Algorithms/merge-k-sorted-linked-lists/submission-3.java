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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        for(ListNode node : lists) {
            if(node != null) heap.offer(node);
        }

        while(!heap.isEmpty()) {
            ListNode cur = heap.poll();
            current.next = new ListNode(cur.val);
            if(cur.next != null) heap.offer(cur.next);
            current = current.next;
        }
        return dummy.next;
    }
}

