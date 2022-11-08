  class LinkedListMid {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;

        ListNode mid = findMid(head);
        TreeNode root = new TreeNode(mid.val);

        if (head == mid) return root; // base case, size one list!

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);

        return root;
    }

    private ListNode findMid(ListNode curr) {
        ListNode slow = curr, fast = curr, prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null) prev.next = null; // disconnect sublist!

        return slow;
    }
}
