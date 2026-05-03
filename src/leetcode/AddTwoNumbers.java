package leetcode;
public class AddTwoNumbers {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return dummyHead.next;
    }

    // Helper method to create a linked list from an array
    public static ListNode createList(int[] nums) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int num : nums) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return dummy.next;
    }

    // Helper method to print the linked list
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + (node.next != null ? " -> " : ""));
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        AddTwoNumbers sol = new AddTwoNumbers();

        // Sample Input 1: (2 -> 4 -> 3) + (5 -> 6 -> 4)
        // Represents 342 + 465 = 807
        ListNode l1 = createList(new int[]{2, 4, 3});
        ListNode l2 = createList(new int[]{5, 6, 4});
        System.out.print("Input 1: ");
        ListNode result1 = sol.addTwoNumbers(l1, l2);
        printList(result1); // Output: 7 -> 0 -> 8

        // Sample Input 2: (9 -> 9 -> 9) + (1)
        // Represents 999 + 1 = 1000
        ListNode l3 = createList(new int[]{9, 9, 9});
        ListNode l4 = createList(new int[]{1});
        System.out.print("Input 2: ");
        ListNode result2 = sol.addTwoNumbers(l3, l4);
        printList(result2); // Output: 0 -> 0 -> 0 -> 1
    }
}
