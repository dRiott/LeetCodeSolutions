class MovePointersInCadence {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    
        ListNode slow = head, fast = head;
        
        // run the fast pointer N moves ahead
        for (int i = 0; i < n; i++) fast = fast.next;
        
        // base case: n == length of the list, fast moved all the way to end (so n from end is head)        
        if (fast == null) return head.next;
        
        // move them both in cadence
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next; 
        return head;
    }
}
