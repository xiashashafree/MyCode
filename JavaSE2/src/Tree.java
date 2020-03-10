import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


public class Tree {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
              if(root==null){
                  return null;
              }
              Queue<TreeNode> q1=new LinkedList<>();
              Queue<TreeNode> q2=new LinkedList<>();
              List<List<Integer>> l=new ArrayList<>();
              l.add(new ArrayList<>());
              l.get(0).set(0,root.val);

              while(q1.size()>0&&q2.size()>0){


              }
return null;
    }
}
