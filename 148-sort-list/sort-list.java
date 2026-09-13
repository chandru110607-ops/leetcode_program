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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null){
            return null;
        }
        List<Integer> values=new ArrayList<>(); 
        ListNode curr=head;
        while(curr!=null){
            values.add(curr.val);
            curr=curr.next;
        }
        Collections.sort(values);
        curr=head;
        int i=0;
        while(curr!=null){
            curr.val=values.get(i);
            i++;
            curr=curr.next;
        }
        return head;
           }
}