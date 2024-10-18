package org.leetcode;
/*
 Write a function to find the longest common prefix string amongst an array of strings.

 If there is no common prefix, return an empty string "".
 */
public class LongestPrefix {
    public static void main(String[] args) {
        LongestPrefix solution = new LongestPrefix();

        // Example input
        String[] strs = {"flower", "flow", "flight"};

        // Call the longestPrefix method
        String result = solution.longestPrefix(strs);

        // Print the result
        System.out.println("The longest common prefix is: " + result);
    }
    public String longestPrefix(String[] strs) {
        String prefix = strs[0];

        if (prefix.isEmpty()) return "";

        for (int i=1; i<strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }
        return prefix;
    }
}
