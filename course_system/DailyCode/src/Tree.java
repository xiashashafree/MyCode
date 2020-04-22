class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Tree {

    /**利用中序遍历和前序遍历结果构造二叉树*/
    int index;

    private TreeNode buildTree(int[] pre, int[] in, int left, int right) {
        if (index >= pre.length || left > right) {
            return null;
        }
        TreeNode node = new TreeNode(pre[index]);
        int inIndex = left;

        while (inIndex <= right) {
            if (in[inIndex] == pre[index]) {
                break;
            }
            inIndex++;
        }
        index++;
        node.left = buildTree(pre, in, left, inIndex - 1);
        node.right = buildTree(pre, in, inIndex + 1, right);
        return node;
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return buildTree(pre, in, 0, pre.length - 1);
    }
}
