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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev=head;
        if(prev.next== null) return new int[]{-1,-1};
        ListNode curr=prev.next;
        if(curr.next== null) return new int[]{-1,-1};
        ListNode next=curr.next;
        List<Integer> li=new ArrayList<>();
        int i=2;
        while(next!=null)
        {
            if((prev.val<curr.val && next.val<curr.val) || (prev.val>curr.val && next.val>curr.val)) li.add(i);
            i++;
            prev=curr;
            curr=next;
            next=next.next;
        }
        if(li.size()<2) return new int[]{-1,-1};
        int min=Integer.MAX_VALUE,max=li.get(li.size()-1)-li.get(0);
        for(i=0;i<li.size()-1;i++) min=Math.min(min,li.get(i+1)-li.get(i));
        return new int[]{min,max};
    }
}