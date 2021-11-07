// https://leetcode.com/problems/triangle/
// Runtime: 2 ms, faster than 92.04% of Java online submissions for Triangle.
// Memory Usage: 38.9 MB, less than 52.02% of Java online submissions for Triangle.

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] res = new int[size + 1];

        for(int i = size - 1; i >= 0; i--){
            List<Integer> row = triangle.get(i);
            for(int j = 0; j < row.size(); j++){
                res[j] = Math.min(res[j], res[j + 1]) + row.get(j);
            }
        }

        return res[0];
    }
}
