//https://leetcode.com/problems/monotone-increasing-digits/

class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] chars = Integer.toString(n).toCharArray();
        for (int i = 0; i < chars.length - 1; ) {   // 0부터 끝까지 검사할거임
            if (chars[i + 1] >= chars[i]) {  // 증가하면 한 칸 씩 뒤로 가고
                i++;
            } else {
                chars[i]--;  // 증가 안 하면 현재 자리에서 1빼고
                for (int j = i + 1; j < chars.length; j++) {
                    chars[j] = '9';   // 내 뒤는 9로 채움. 그게 제일 증가하면서 큰 숫자이니까
                }
                if (i > 0) {  // 현재 자리 숫자도 변경됐으니까 다시 검증해야 함.
                    i--;      // 한 칸 앞으로 다시 돌아가서 검증하기
                }             // 현재 자리가 맨 앞이면 불필요하니까 i > 0 일 때만
            }
        }

        return Integer.parseInt(new String(chars));
    }
}
