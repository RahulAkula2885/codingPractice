package com.example.practice;

import java.util.HashSet;
import java.util.Set;

public class StringExamples {
    public static void main(String[] args) {

        longestSubstring();

        reverseAString();
    }

    private static void reverseAString() {
        System.out.println("******************************** Reverse a String ********************************");
        String str = "luhaR";
        String rev ="";

        for(int i = str.length()-1; i >=0; i--){
            rev += str.charAt(i);
        }
        System.out.println(rev);
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
