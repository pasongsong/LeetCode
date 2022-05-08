// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

class Solution {
    TreeNode mP, mQ, mRet;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        mP = p;
        mQ = q;

        find(root);
        return mRet;
    }

    boolean find(TreeNode cur) {
        int me = 0, left = 0, right = 0;
        if (cur == mP || cur == mQ) {
            me = 1;
        }
        if (cur.left != null && find(cur.left)) {
            left = 1;

        }
        if (cur.right != null && find(cur.right)) {
            right = 1;
        }

        if (me + left + right == 2) {
            mRet = cur;
            return true;
        } else if (me + left + right == 1) {
            return true;
        } else {
            return false;
        }
    }
}
