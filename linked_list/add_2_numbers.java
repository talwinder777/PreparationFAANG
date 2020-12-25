/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode curr = temp;
        int carry = 0;
        
        while(l1 != null || l2 != null){
            int x = 0, y = 0, sum = 0;
            
            if(l1 != null)
                sum += l1.val;
            if(l2 != null)
                sum += l2.val;
            sum += carry; // carry would either be 0 or 1
            
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(carry == 1)
            curr.next = new ListNode(carry);
        return temp.next;
    }
}
