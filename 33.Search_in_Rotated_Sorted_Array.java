// https://leetcode.com/problems/search-in-rotated-sorted-array/
// 채점 : 0 ms	39.3 MB
// 시간복잡도 : O(logN) 공간복잡도 : O(1)


class Solution {
    public int search(int[] nums, int target) {
        final int size = nums.length, first = nums[0];
        int start = 1, end = size - 1 , mid, ans = 0;
        int min = first, minIdx = 1;
        
        if (first > nums[end]) {      // 이진탐색 베이스로 가장 작은 값의 인덱스찾기
            while (end >= start) {
                mid = (start + end) / 2;
                if (nums[mid] > first) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                   if (nums[mid] < min) { 
                        min = nums[mid];
                        minIdx = mid;
                   }
                }
            }
        }
       
        // min 값 기준으로 문제값 두 영역에서 찾기 
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
