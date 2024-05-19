package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _56_Merge_Intervals {
    public int[][] merge(int[][] intervals) {
        
        if(intervals.length == 1){
            return intervals;
        }
        int min = intervals[0][0];
        int max = intervals[0][1];
        ArrayList<int[]> result = new ArrayList<>();
        for(int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= max && intervals[i][1] >= max){
                int[] arrayTemp = {min,intervals[i][1]};
                result.add(arrayTemp);

            } else {
                result.add(intervals[i]);
            }
            min = intervals[i][0];
            System.out.println(min);
        }
        int[][] array_result = new int[result.size()][2];
        for(int i = 0; i < result.size(); i++) {
            array_result[i][0] = result.get(i)[0];
            array_result[i][1] = result.get(i)[1];
        }
        return array_result;   
    }

    //----------------------------------------------------

    public int[][] mergeOtimized(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        int[] currentInterval = intervals[0];
        result.add(currentInterval);

        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];
            if (currentEnd >= nextStart) {
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                currentInterval = interval;
                result.add(currentInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
