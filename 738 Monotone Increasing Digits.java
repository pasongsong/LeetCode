//https://leetcode.com/problems/monotone-increasing-digits/

class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] chars = Integer.toString(n).toCharArray();
        for (int i = 0; i < chars.length - 1; ) {
            if (chars[i + 1] >= chars[i]) {
                i++;
            } else {
                if (i > 0) {
                    chars[i]--;
                    for (int j = i + 1; j < chars.length; j++) {
                        chars[j] = '9';
                    }
                    i--;
                } else {
                    chars[0]--;
                    for (int j = 1; j < chars.length; j++) {
                        chars[j] = '9';
                    }
                }
            }
        }

        return Integer.parseInt(new String(chars));
    }
}
