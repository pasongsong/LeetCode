// https://leetcode.com/problems/wiggle-subsequence/
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Wiggle Subsequence.
// Memory Usage: 36.5 MB, less than 78.80% of Java online submissions for Wiggle Subsequence.

public class Solution {
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length, up = 1, down = 1;

        if (len <= 1)
            return len;
        
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1])
                up = down + 1;
            else if (nums[i] < nums[i - 1])
                down = up + 1;
        }
        return Math.max(up, down);
    }
}
