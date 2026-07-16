public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            nodes.add(cur);
            cur = cur.next;
        }

        int removeIndex = nodes.size() - n;
        if (removeIndex == 0) {
            return head.next;
        }

        nodes.get(removeIndex - 1).next = nodes.get(removeIndex).next;
        return head;
    }
}
