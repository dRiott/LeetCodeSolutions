class MidPointReversedStitched {
    public void reorderList(ListNode head) {
        // find midpoint with two pointers
        ListNode middle = head, fast = head;
        while (fast != null && fast.next != null) {
            middle = middle.next;
            fast = fast.next.next;
        }

        // reverse second half
        ListNode prev = null, curr = middle, tmp = null;
        while (curr != null) {
            tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        // stitch together
        ListNode first = head, second = prev;
        while (second.next != null) {
            tmp = first.next;
            first.next = second;
            first = tmp;

            tmp = second.next;
            second.next = first;
            second = tmp;
        }
    }
}
