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
    public ListNode reverseList(ListNode head) {
        ListNode t=head;
        ListNode pre=null;
        ListNode nx=null;
        while(t!=null)
        {
            nx=t.next;
            t.next=pre;
            pre=t;
            t=nx;
        }
        return pre;

    }
}