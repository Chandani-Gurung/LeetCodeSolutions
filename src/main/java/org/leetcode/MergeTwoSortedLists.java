package org.leetcode;

/*
You are give then heads of two sorted linked lists, list1 and list2. Merge the two lists into one sorted list.
The list should be made by splicing together the nodes of the first two lists.
EG:
l1 = 1 -> 2 -> 4
l2 = 1 -> 3 -> 4
output = 1 -> 1 -> 2 -> 3 -> 4 -> 4
 */

public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode tempNode = new ListNode(0);
        ListNode currentNode = tempNode;

        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                currentNode.next = list1;
                list1 = list1.next;
            } else {
                currentNode.next = list2;
                list2 = list2.next;
            }

            currentNode = currentNode.next;
        }
        if (list1 != null) {
            currentNode.next = list1;
            list1 = list1.next;
        }
        if (list2 != null) {
            currentNode.next = list2;
            list2 = list2.next;
        }
        return tempNode.next;
    }

    // Helper method to create a linked list from an array of values
    public static ListNode createLinkedList(int[] values) {
        if (values.length == 0) return null;

        ListNode head = new ListNode(values[0]);
        ListNode current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        return head;
    }

    // Helper method to print the linked list
    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create two sample linked lists
        ListNode list1 = createLinkedList(new int[]{1, 2, 4});
        ListNode list2 = createLinkedList(new int[]{1, 3, 4});

        // Merge the two lists
        ListNode mergedList = mergeTwoLists(list1, list2);

        // Print the merged list
        printLinkedList(mergedList);
    }
}
