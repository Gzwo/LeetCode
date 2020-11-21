public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head, answer;

        /* 测试样例应当包含：
           头结点为空（1）
           仅1个节点（1）
           仅2个节点（1）
           3个或以上节点（若干） */

        // test 1
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        head = n1;
        answer = solution.oddEvenList(head);
        ListNodeUtils.traverse(answer);

    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        /* 处理特殊情形：头结点为空或只有1个节点 */
        if (head == null || head.next == null) {
            return head;
        }

        ListNode o = head;
        ListNode p = head.next;
        ListNode e = p;
        while (o.next != null && e.next != null) {
            o.next = e.next;
            o = o.next;
            e.next = o.next;
            e = e.next;
        }
        o.next = p;
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class ListNodeUtils {
    public static void traverse(ListNode head) {
        if (head == null) {
            System.out.println("head == null");
        } else {
            ListNode cur = head;
            while (cur != null) {
                System.out.printf("%d", cur.val);
                if (cur.next != null) {
                    System.out.print("->");
                }
                cur = cur.next;
            }
            System.out.println();
        }
    }
}