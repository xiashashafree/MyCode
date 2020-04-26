


 // Definition for a binary tree node.
 class TreeNode1 {
      int val;
      TreeNode1 left;
      TreeNode1 right;
      TreeNode1(int x) { val = x; }
  }

public class StructTree1 {
    int index = 0;

    private TreeNode1 buildTree(int[] inorder, int[] postorder, int left, int right) {
        if (index < 0 || left >= right) {
            return null;
        }

        TreeNode1 root = new TreeNode1(postorder[index]);
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

    public TreeNode1 buildTree(int[] inorder, int[] postorder) {
        index = postorder.length - 1;
        return buildTree(inorder, postorder, 0, postorder.length - 1);

    }
}
