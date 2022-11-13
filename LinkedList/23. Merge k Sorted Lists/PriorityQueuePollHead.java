class PriorityQueuePollHead {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length ==0) return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (ln1, ln2) -> ln1.val - ln2.val);

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for (ListNode head : lists) {
            if (head != null) pq.add(head);
        }
      
        while (!pq.isEmpty()){
            ListNode node = pq.poll();
            curr.next = node;
            if (node.next != null) pq.add(node.next);
            curr = curr.next;
        }

        return dummy.next;
    }
}
