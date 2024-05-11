package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class _1431_Kids_with_Greatest_num_Candies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int maxCandies = 0;
        for(int i = 0; i < candies.length; i++) {
            maxCandies = Math.max(maxCandies, candies[i]);
        }
        for(int i = 0; i < candies.length; i++) {
            if(candies[i] + extraCandies >= maxCandies){
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    //Time Complexity: O(n) where n is the number of elements in candies
    //Space Complexity: O(n) where n is the nomber of elements in result
    }
    
}
