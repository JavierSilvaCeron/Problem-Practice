package LeetCode;


public class _2340_Minimun_Adjacent_Sawps_to_Make_Array {
    public int minimumSwaps(int[] nums) {
        int maxi = nums.length - 1, mini = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[maxi] < nums[nums.length - 1 - i]) {
                maxi = nums.length - 1 - i;
            }
            if (nums[mini] > nums[i]) {
                mini = i;
            }
        }
        int totalSwaps;
        if (mini > maxi) {
            totalSwaps = (nums.length - 1 - maxi) + mini - 1;
        } else {
            totalSwaps = (nums.length - 1 - maxi) + mini ;
        }
        return totalSwaps;
    }

}
