package Java06_23;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Partition {
    public ListNode partition(ListNode pHead, int x) {
        // write code here
        if (pHead == null) {
            return pHead;
        }
        ListNode minHead = new ListNode(-1);
        ListNode minTail = minHead;
        ListNode maxHead = new ListNode(-2);
        ListNode maxTail = maxHead;
        ListNode cur = pHead;
        while (cur != null) {
            if (cur.val < x) {
                minTail.next = cur;
                minTail = minTail.next;
            } else {
                maxTail.next = cur;
                maxTail = maxTail.next;
            }
            cur = cur.next;
        }
        minTail.next = maxHead.next;
        maxTail.next = null;
        return minHead.next;
    }
}
