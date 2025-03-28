package org.leetcode;

import java.util.HashSet;
import java.util.Scanner;

public class ContainDuplicate {
    // Utilizing HashSet
    public boolean containsDuplicate(int[] nums) {
        // Create new HashSet
        HashSet<Integer> duplicateSet = new HashSet<>();

        // Iterating through each number in nums array
        for (int num : nums) {
            if (duplicateSet.contains(num)) { // if num is already in duplicate set duplicate found
                return true;
            }
            duplicateSet.add(num); // else add the num in the set
        }
        return false;
    }

    public static void main(String[] args) {
        ContainDuplicate containDuplicate = new ContainDuplicate();
        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.println("Enter the number of elements in the array you want to check: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Accept the array elements
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Check if there are duplicates and print the result
        boolean result = containDuplicate.containsDuplicate(nums);
        if (result) {
            System.out.println("The array contains duplicates.");
        } else {
            System.out.println("The array does not contain duplicates.");
        }
        sc.close();
    }
}
