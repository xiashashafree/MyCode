package AOneQuestionPerDay;
import java.util.*;
public class Try {


public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}


        int K =0;
        TreeNode ret = null;
        void getNode(TreeNode pRoot){
            if(pRoot == null){
                return;
            }

            getNode(pRoot.left);

            K--;
            if(K == 0){
                ret  = pRoot;
                return;
            }

            getNode(pRoot.right);





        }
        TreeNode KthNode(TreeNode pRoot, int k)
        {
            K = k;
            getNode(pRoot);
            return ret;
        }


    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if(pRoot == null){
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        int i = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for(int j=0;j<size;j++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            if(i%2 == 0){
                Collections.reverse(list);
            }
            ret.add(list);
            i++;
        }
        return ret;
    }



}
