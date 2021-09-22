//https://leetcode.com/problems/search-in-rotated-sorted-array/

class Solution {
    public int search(int[] nums, int target) {
        final int size = nums.length, first = nums[0];
        int start = 1, end = size - 1 , mid, ans = 0;
        int min = first, minIdx = 1;
        
        if (first > nums[end]) {      
            while (end >= start) {
                mid = (start + end) / 2;
                if (nums[mid] > first) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                   if (nums[mid] < min) { //나중에 빼보기
                        min = nums[mid];
                        minIdx = mid;
                   }
                }
            }
        }
       
        
        if (min == first) {
            ans = Arrays.binarySearch(nums, 0, size, target);  
        } else {
            if (target < first) {
                ans = Arrays.binarySearch(nums, minIdx, size, target);
            } else if (target > first) {
                ans = Arrays.binarySearch(nums, 1, minIdx, target);  
            } else {
                ans = 0;
            }
        }
        

        return ans >= 0 ? ans : -1;
    }
}
