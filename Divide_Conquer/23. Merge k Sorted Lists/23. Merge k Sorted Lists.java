class Solution {
    // divide & conquer
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return dfs(lists, 0, lists.length-1);
    }
    private ListNode dfs(ListNode[] lists, int start, int end) {
        if (start >= end) return lists[start];
        int mid = start + (end-start)/2;
        ListNode left = dfs(lists, start, mid);
        ListNode right = dfs(lists, mid+1, end);
        // conquer
        // merge two sorted list
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                prev.next = new ListNode(left.val);
                left = left.next;
            } else {
                prev.next = new ListNode(right.val);
                right = right.next;
            }
            prev = prev.next;
        }
        if (left != null) prev.next = left;
        if (right != null) prev.next = right;
        return dummy.next;
    }
}
