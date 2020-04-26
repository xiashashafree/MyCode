
    public class StructTree2 {
        int index=0;
        private TreeNode1 buildTree(int[] preorder,int[] inorder,int left,int right){
            if(index>=preorder.length||left>right){
                return null;
            }

            TreeNode1 root=new TreeNode1(preorder[index]);

            int inrootIdx=left;

            while(inrootIdx<=right){
                if(inorder[inrootIdx]==preorder[index]){
                    break;
                }
                inrootIdx++;
            }
            index++;

            root.left=buildTree(preorder,inorder,left,inrootIdx-1);
            root.right=buildTree(preorder,inorder,inrootIdx+1,right);

            return root;
        }
        public TreeNode1 buildTree(int[] preorder, int[] inorder) {
            return buildTree(preorder,inorder,0,preorder.length-1);
        }
    }

