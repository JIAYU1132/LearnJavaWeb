package Java06_26;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}

// 二叉树平衡检查
// 求出左右子树的最高深度，然后高度差不超过1
public class Balance {
    public boolean isBalance(TreeNode root) {
        // write code here
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return false;
        }
        // 左右子树最高深度差的绝对值小于1
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if (leftDepth - rightDepth > 1 || leftDepth - rightDepth < -1) {
            return false;
        }
        // 左右子树也为平衡二叉树，才返回true
        return isBalance(root.left) && isBalance(root.right);
    }

    // 最大深度就是左右子树中深度最大的数 + 1
    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.right == null && root.left == null) {
            return 1;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
