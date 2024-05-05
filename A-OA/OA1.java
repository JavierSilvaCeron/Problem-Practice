
import java.util.ArrayList;
import java.util.HashMap;
//import java.lang.StringBuilder;

/**
 *
 * @author Javi
 */

public class OA1 {
    /*
    1. Code Question 1
    The developers at Amazon employ several algorithms for encrypting passwords. In one algorithm, the developers aim ti encrypt palindromic passwords. Palindromic passwords are ones that read the same foward and backward.
    The algorithm rearranges the characters to have the following characteristics:
    It is a rearrangement of the original palindromic password.
    It is also a palindrome
    Among all such palindromic rearrangements, it is the lexicographically smallest.
    Given the original palindromic password that consists of lowercase English characters only, find the encrypted password. A String is considered to be lexicographically smaller than the string t of the same length if the first character in s that differs from that in t is smaller. For example, ¨abcd¨ is lexicographically smaller than ¨abdc¨ but larger than ¨abad¨
    Note that the encrypted password might be the same as the original password if it is already lexicographically smallest.
    Example:
    The original password is password = "babab"
    This can be rearranged to form abbba, witch is both a rearrangement of the original password and the lexicographically smallest palindrome.
    It satisfies all the requirements so return the string abbba.
    Funtion Description:
    Complete the function findEncryptedPassword in the editor below:

    findEncryotedPassword has the following paramenters:
    string password: the original palindromic password

    Returns:
    String: the encrypted password
    Constrains:
    -> 1<= password <= 10^5
    -> password consists of lercase English letters only.
    -> password is a palindrome.

    Sample Case 0:
    yxxy -> xyyx 
    Rearrange the original password to form xyyx which is also a palindrome and is the smallest possible rearrangement.
    Sample Case 1:
    ded -> ded

    */
    
    public String findEncryptedPasswordJavi(String password) {
        Character[] abc = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        HashMap<Character, Integer> orderAbc = new HashMap<>();
        for(int i = 0 ; i < abc.length; i ++) {
            orderAbc.put(abc[i], i);
        }
        ArrayList<String> possiblePasswords = getPossiblePasswords(password);
        String result = password;
        for(String possiblePassword : possiblePasswords) {
            if(comparePasswords(orderAbc, result, possiblePassword) > 0) {
                result = possiblePassword;
            }
        }
        return result;
    }
    // Time Complexity: O(n*m) where n is the number of possible passwords generated and m is the length of the longest password
    // Space Complexity: O(n) where n are all the posible rearrendments of the word password

    public ArrayList<String> getPossiblePasswords(String password) {

        ArrayList<String> possiblePasswords = new ArrayList<>();
        possiblePasswords.add(password); // Temporary placeholder
        return possiblePasswords;

    }
    private int comparePasswords(HashMap<Character, Integer> orderAbc, String password1, String password2) {
        for (int i = 0; i < Math.min(password1.length(), password2.length()); i++) {
            int order1 = orderAbc.get(password1.charAt(i));
            int order2 = orderAbc.get(password2.charAt(i));
            if (order1 != order2) {
                return Integer.compare(order1, order2);
            }
        }
        return Integer.compare(password1.length(), password2.length());
    }
    //--------------------------------------------------------------------------------------------------------------------------
    



    //--------------------------------------------------------------------------------------------------------------------------
    /* 
    public String findEncryotedPassword(String password) {
        Character[] abc = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','u','r','s','t','u','w','x','y','x'};
        int[] apearence = new int[25];
        
        for(int i = 0 ; i < password.length(); i ++) {
            int poss = password.charAt(i);
            apearence[poss] = apearence[poss] + 1;
        }
        
        Character[] result = new Character[password.length()];
        
        StringBuilder nw = new StringBuilder();
        int index = 0;
        for(int i = 0; i < apearence.length; i++) {
            if(apearence[i] > 0) {
                for(int j = apearence[i]; j > 0; j--) {
                    if(j % 2 == 0) {
                        nw.append(abc[apearence[i]], i, i);
                        nw.append(abc[apearence[i]], i, i);
                    }
                }
                
            }
            
        }
        
        
        
        return result;
    }
    */
    
    
}
