package org.leetcode;

/*
Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.
 */
public class BinarySearch {
    public int search(int[] nums, int target) {

        if (nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int midP = left + (right - left) / 2;

            if (nums[midP] == target) {
                return midP;
            } else if (nums[midP] < target) {
                left = midP + 1;
            } else {
                right = midP - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch solution = new BinarySearch();
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;

        int result = solution.search(nums, target);

        if (result != -1) {
            System.out.println("Target found at index: " + result);
        } else {
            System.out.println("Target not found in the array.");
        }
    }
}
