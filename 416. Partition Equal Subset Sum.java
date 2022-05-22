//https://leetcode.com/problems/partition-equal-subset-sum/
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int half = sum / 2;


        if (sum % 2 != 0) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        set.add(0);

        for (int n : nums) {
            Set<Integer> currentSum = new HashSet<>();
            for (int s : set) {
                if (s + n == half) {
                    return true;
                } else if (s + n < half) {
                    currentSum.add(s + n);
                }
            }
            set.addAll(currentSum);
        }
        return false;
    }
}
