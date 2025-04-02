package org.leetcode;

/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.



Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 */
public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int answer[] = new int[n];

        //Calculate the left products for each i in nums and store in answer[]

        int leftProduct = 1;
        for (int i = 0; i < n; i++) {
            answer[i] = leftProduct; //leftProduct represents product of all nums before i
            leftProduct *= nums[i];
        }

        // Calculate the right product
        // Multiply each element in answer[i] which has the left products by right prods
        //which ensures each index holds prods except for itself

        int rightProduct = 1;
        for (int i = n-1; i >= 0; i--) {
            answer[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();

        int[] nums = {1, 2, 3, 4};
        int[] result = productOfArrayExceptSelf.productExceptSelf(nums);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
