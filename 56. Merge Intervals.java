//https://leetcode.com/problems/merge-intervals/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Hi {
    public static void main(String[] args) {

        Solution solution = new Solution();
        int[][] res = solution.merge(new int[][] {{1,4}, {0,2},{3,5}});
        for (int i = 0; i < res.length; i++){
            System.out.println(res[i][0] + ", " + res[i][1]);
        }
    }


}

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        ArrayList<int[]> arr = new ArrayList<int[]>();
        arr.add(intervals[0]);
        for (int i = 0; i < intervals.length - 1; i++) {
            int lastIdx = arr.size() - 1;
            int[] lastVal = arr.get(lastIdx);
            if (intervals[i + 1][0] <= lastVal[1]) {
                arr.set(lastIdx, new int[]{lastVal[0], Math.max(intervals[i + 1][1], lastVal[1])});
            } else {
                arr.add(intervals[i + 1]);
            }
        }
        return arr.toArray(new int[arr.size()][2]);
    }
}
