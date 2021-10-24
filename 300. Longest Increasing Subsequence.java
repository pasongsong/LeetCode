// https://leetcode.com/problems/longest-increasing-subsequence/

class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int target = nums[i];
            if (target > arr.get(arr.size() - 1)) {
                arr.add(target);
            } else {
                for (int j = arr.size() - 1; j >= 0; j--) {
                    if (target > arr.get(j)) {
                        arr.set(j + 1, target);
                        break;
                    } else if (j == 0) {
                        arr.set(j, target);
                    }
                }
            }
        }
        return arr.size();
    }
}

