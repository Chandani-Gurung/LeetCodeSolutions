package org.leetcode;

/*
Given two strings s and t, return true if t is an
anagram of s, and false otherwise.
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;

        int[] char_count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char_count[s.charAt(i) - 'a']++;
            char_count[t.charAt(i) - 'a']--;
        }

        for (int count : char_count) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram solution = new ValidAnagram();
        String s = "anagram";
        String t = "nagaram";

        Boolean result = solution.isAnagram(s, t);
        System.out.println(result);
    }
}
