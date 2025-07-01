/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode colide=hasCycle(head);
        if(colide==null) return null;
        ListNode ptr=head;
        while(ptr!=colide)
        {
            colide=colide.next;
            ptr=ptr.next;
        }
        return ptr;
    }
    public ListNode hasCycle(ListNode head)
    {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) return slow;
        }
        return null;
    }
}