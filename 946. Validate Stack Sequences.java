//https://leetcode.com/problems/validate-stack-sequences/

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        boolean res = false;
        int len = pushed.length;
        int popIdx = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            if (pushed[i] == popped[popIdx])  {
                popIdx++;
            } else if (!stack.empty() && stack.peek() == popped[popIdx]) {
                popIdx++;
                stack.pop();
                i--;
            } else {
                stack.push(pushed[i]);
            }
        }

        while (!stack.empty()) {
            if (stack.pop() != popped[popIdx++]) {
                return false;
            }
        }

        return true;       
    }
}
