class MergeTwoListsKTimes {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        ListNode result = mergeTwoLists(lists[0], lists[1]);
        for (int i = 2; i < lists.length; i++) {
            result = mergeTwoLists(result, lists[i]);
        }
        return result;
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);

        ListNode curr = dummy;
        while(list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    curr.next = list1;
                    list1 = list1.next;
                } else {
                    curr.next = list2;
                    list2 = list2.next;
                }
                curr = curr.next;
        }

        curr.next = list1 == null ? list2 : list1;

        return dummy.next;
    }
}
