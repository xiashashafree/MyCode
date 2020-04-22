
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class StructTree1 {
    int index = 0;

    private TreeNode buildTree(int[] inorder, int[] postorder, int left, int right) {
        if (index < 0 || left >= right) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[index]);
        int inrootIdx = left;

        while (inrootIdx < right) {
            if (inorder[inrootIdx] == postorder[index]) {
                break;
            }
            inrootIdx++;
        }
        index--;

        root.right = buildTree(inorder, postorder, inrootIdx + 1, right);
        root.left = buildTree(inorder, postorder, left, inrootIdx);

        return root;

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = postorder.length - 1;
        return buildTree(inorder, postorder, 0, postorder.length - 1);

    }
}
