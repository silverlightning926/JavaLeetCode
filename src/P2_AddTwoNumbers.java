/*
    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */

import util.ListNode;

public class P2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode current = result;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return result.next;
    }

    public static void main(String[] args) {
        P2_AddTwoNumbers solution = new P2_AddTwoNumbers();

        // Test 1
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = solution.addTwoNumbers(l1, l2);
        assert result.getVal() == 7;

        // Test 2
        l1 = new ListNode(0);
        l2 = new ListNode(0);
        result = solution.addTwoNumbers(l1, l2);
        assert result.getVal() == 0;

        // Test 3
        l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9,
                new ListNode(9, new ListNode(9, new ListNode(9)))))));
        l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        result = solution.addTwoNumbers(l1, l2);
        assert result.getVal() == 8;

        System.out.println("All tests passed.");
    }
}
