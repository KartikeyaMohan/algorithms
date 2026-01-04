/**
 * Leetcode 234
 * Given the head of a singly linked list, return true 
 * if it is a palindrome or false otherwise.
 */
class PalindromeLL {

    ListNode curr;
    public boolean isPalindrome(ListNode head) {
        curr = head;
        return check(head);
    }

    private boolean check(ListNode head) {
        if (head == null) {
            return true;
        }
        boolean output = check(head.next) && head.val == curr.val;
        curr = curr.next;
        return output;
    }

    public static void main(String[] args) {
        PalindromeLL object = new PalindromeLL();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(object.isPalindrome(head));
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