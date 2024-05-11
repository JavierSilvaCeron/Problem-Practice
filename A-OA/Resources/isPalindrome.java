package Resources;

public class isPalindrome {
    public boolean isPalindromeSol(String s) {
        if (s == null || s.length() == 0) {
            return true; 
        }
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false; 
            }
            left++;
            right--;
        }
        return true; 
    }

    //-------------------------------------------------------

    public boolean isPalindromeSol(int number) {
        String numString = String.valueOf(number);
        int left = 0;
        int right = numString.length() - 1;
        while (left < right) {
            if (numString.charAt(left++) != numString.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
    


}
