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
        int size=0;
        ListNode temp=head;
        while(temp!=null)
        {
            size++;
            temp=temp.next;
        }

        int swapnode=size-k;
        temp=head;
        while(swapnode-->0)
        {
            temp=temp.next;
        }
        ListNode temp2=head;
        while(--k>0)
        {
            temp2=temp2.next;
        }
        int x=temp.val;
        temp.val=temp2.val;
        temp2.val=x;
        return head;
    }
}