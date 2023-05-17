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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int size = 0;
        ListNode temp = dummy;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        ListNode start = dummy;
        for (int i = 0; i < k; i++) {
            start = start.next;
        }

        ListNode end = dummy;
        for (int i = 0; i < size - k; i++) {
            end = end.next;
        }

        int tempVal = start.val;
        start.val = end.val;
        end.val = tempVal;

        return dummy.next;
    }
}