package com.example.practice;

import java.util.HashSet;
import java.util.Set;

public class StringExamples {
    public static void main(String[] args) {

        longestSubstring();
    }

    private static void longestSubstring() {

        String s = "ababcabcdbca";
        Set<Character> set = new HashSet<>();
        int left = 0, max = 0;

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(right));
            max = Math.max(max, right - left + 1);
        }
        System.out.println(max);
    }
}
