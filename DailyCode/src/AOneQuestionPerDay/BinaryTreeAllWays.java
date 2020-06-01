package AOneQuestionPerDay;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeAllWays {
    List<String> ret = new ArrayList<>();
    private void add(TreeNode root,String s){
        if(root.left == null && root.right == null){
            s = s+root.val;
            ret.add(s);
        }else{
            s = s+root.val+"->";
            if(root.left != null){

                add(root.left,s);
            }
            if(root.right != null){
                add(root.right,s);
            }
        }
    }


    public List<String> binaryTreePaths(TreeNode root) {

        if(root == null){
            return ret;
        }
        String s = "";
        add(root,s);
        return ret;

    }
}
