package org.leetcode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class AddTwoNums {
    public static void main(String[] args) {
        AddTwoNums addTwoNums = new AddTwoNums();

        // Create first number: 342 represented as 2 -> 4 -> 3
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // Create second number: 465 represented as 5 -> 6 -> 4
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        // Add the two numbers
        ListNode result = addTwoNums.addTwoNumbers(l1, l2);

        // Print the result
        System.out.print("Result: ");
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
            if (result != null) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        int carry = 0;
        while(l1!=null || l2!=null || carry!=0) {
            int l1_val = (l1!=null) ? l1.val : 0;
            int l2_val = (l2!=null) ? l2.val : 0;
            int sum = l1_val + l2_val + carry;
            carry = sum/10;
            int last_digit = sum%10;

            ListNode newNode = new ListNode(last_digit);
            tail.next = newNode;
            tail = tail.next;

            l1 = (l1!=null) ? l1.next : null;
            l2 = (l2!=null) ? l2.next : null;
        }
        if(carry>0) {
            ListNode new_node = new ListNode(1);
            tail.next = new_node;
            tail = tail.next;
        }
        return dummyHead.next;
    }
}
