package LeetCode;

public class _2330_Valid_Palindrome_IV {
    public boolean makePalindrome(String s) {
        int numberOfInconsistences = isPalindrome(s);
        if (numberOfInconsistences <= 2) {
            return true;
        } else {
            return false;
        }
    }

    public int isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int left = 0;
        int right = s.length() - 1;
        int inconsistencies = 0;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                inconsistencies++;
            }
            left++;
            right--;
        }
        return inconsistencies;
    }

}