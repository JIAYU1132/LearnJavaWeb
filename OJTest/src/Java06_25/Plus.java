package Java06_25;

//链式A+B

//有两个用链表表示的整数，每个结点包含一个数位。这些数位是反向存放的，也就是个位排在链表的首部。
// 编写函数对这两个整数求和，并用链表形式返回结果。
//给定两个链表ListNode* A，ListNode* B，请返回A+B的结果(ListNode*)。
//
//测试样例：
//{1,2,3},{3,2,1}
//返回：{4,4,4}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Plus {
    public ListNode plusAB(ListNode a, ListNode b) {
        // write code here
        // 注意考虑进位情况
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        int sum = 0;
        while (a != null || b != null || sum != 0) {
            if (a != null) {
                sum += a.val;
                a = a.next;
            }
            if (b != null) {
                sum += b.val;
                b = b.next;
            }
            cur.next = new ListNode(sum % 10);
            sum /= 10;
            cur = cur.next;
        }
        return res.next;
    }
}
