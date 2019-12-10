package Solution;

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        head.next = removeElements(head.next, val);
        if(head.val == val){
            return head.next;
        }else{
            return head;
        }
    }
}
