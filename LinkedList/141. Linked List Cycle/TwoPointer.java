public class TwoPointer {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow.equals(fast)) {
                return true;
            }
        }
        return false;
    }
}
