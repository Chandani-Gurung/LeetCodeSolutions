package org.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
 * Given a string s, find the length of the longest substring
 * without repeating characters.
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        LengthOfLongestSubstring solution = new LengthOfLongestSubstring();

        // Example input
        String input = "abcabcbb";

        // Call the lengthOfLongestSubstring method
        int result = solution.lengthOfLongestSubstring(input);

        // Print the result
        System.out.println("The length of the longest substring without repeating characters is: " + result);
    }
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();
        int left = 0;
        for (int right=0; right<n; right++) {
            while (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            }
            charSet.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
