package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class _3_Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) {
            return s.length();
        }
        if(s.length() == 2) {
            if(s.charAt(0) == s.charAt(1)) {
                return 1;
            } else {
                return 2;
            }
        }
        int maxCharacter = 0;
        Set<String> repeatedWords = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            for(int j = i; j <= s.length(); j++) {
                if(s.substring(i, j).length() > maxCharacter && !repeatedWords.contains(s.substring(i, j))) {
                    maxCharacter = Math.max(maxCharacter, substringUnique(s.substring(i, j)));
                    repeatedWords.add(s.substring(i, j));
                }
            }
        }
        return maxCharacter;
        //Time Complexity: O(n^3) where n is the number of characters in s
        //Space Complexity: O(n) where n is the number of characters in s
    }

    public int substringUnique(String word) {
        System.out.println(word);
        Set<Character> dictionary = new HashSet<>();
        for(int i = 0; i < word.length(); i ++) {
            if(dictionary.contains(word.charAt(i))) {
                return 0;
            } else {
                dictionary.add(word.charAt(i));
            }
        }
        return word.length();
    }

    //---------------------------------------------------------------------------------------------------------

    public int lengthOfLongestSubstringOptimiced(String s) {
        if(s.length() == 1) {
            return 1;
        }
        int num = 0;
        for(int i = 0; i < s.length(); i++) {
            Set<Character> dictionay = new HashSet<>();
            int count = 0;
            for(int j = i; j < s.length(); j++) {
                if(!dictionay.contains(s.charAt(j))) {
                    count++;
                    num = Math.max(num, count);
                    dictionay.add(s.charAt(j));
                } else {
                    break;
                }
            }
        }
        
        return num;
        //Time Complexity: O(n^2) where n is the number of characters in s
        //Space Complexity: O(n) where n is the number of characters in s
    }

}
