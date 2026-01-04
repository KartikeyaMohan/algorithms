/**
 * Leetcode 206
 * Given the head of a singly linked list, reverse the list,
 * and return the reversed list.
 */
class ReverseLL {

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ReverseLL object = new ReverseLL();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode output = object.reverseList(head);
        while (output != null) {
            System.out.print(output.val + " ");
            output = output.next;
        }
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