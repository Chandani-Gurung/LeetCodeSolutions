package org.leetcode;

/*
Given an array of strings strs, group the anagrams together.
You can return the answer in any order.
 */

import java.util.*;

public class GroupAnagram {
    public static List<List<String>> groupAnagrams(String[] strs) {
        // utilizing hashmap's key value feature
        Map<String, List<String>> anagramMap = new HashMap<>();

        // for each word in strs array
        for (String word : strs) {
            // convert to char array so ["eat"] => ["e", "a", "t"]
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            // sortedWord will be ["aet"] which is our key
            // our values are the list of strings that match with our key
            String sortedWord = new String(charArray);

            anagramMap.putIfAbsent(sortedWord, new ArrayList<>());
            /*
            We could also use
            if (!anagramMap.containsKey(sortedWord) {
                anagramMap.put(sortedKey, new ArrayList<>());
            }
             */
            anagramMap.get(sortedWord).add(word);
        }

        return new ArrayList<>(anagramMap.values());

    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
}

// Time complexity = O(NK log K)
// Space = O(NK)
