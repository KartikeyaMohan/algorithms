/**
 * Leetcode 203
 * Given the head of a linked list and an integer val,
 * remove all the nodes of the linked list that has
 * Node.val == val, and return the new head.
 */
class RemoveLLElements {

    private ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        head.next = removeElements(head.next, val);

        if (head.val == val) {
            return head.next;
        }

        return head;
    }

    public static void main(String[] args) {
        RemoveLLElements object = new RemoveLLElements();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);
        int removeElement = 6;
        ListNode output = object.removeElements(head, removeElement);
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