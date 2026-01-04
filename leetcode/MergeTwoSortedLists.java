/**
 * Leetcode 21
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list. The list should be made
 * by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 */
class MergeTwoSortedLists {

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null || list2 == null) {
            return list1 != null ? list1 : list2;
        }

        if (list1.val > list2.val) {
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }

        list1.next = mergeTwoLists(list1.next, list2);
        return list1;
    }

    public static void main(String[] args) {
        MergeTwoSortedLists object = new MergeTwoSortedLists();
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        ListNode output = object.mergeTwoLists(list1, list2);
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