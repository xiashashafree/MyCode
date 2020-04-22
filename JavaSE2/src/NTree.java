import java.util.ArrayList;
import java.util.List;

class NNode {
    public int val;
    public List<NNode> children;

    public NNode() {}

    public NNode(int _val) {
        val = _val;
    }

    public NNode(int _val, List<NNode> _children) {
        val = _val;
        children = _children;
    }
}
public class NTree {
    /**N叉树的后序遍历*/
    private List<Integer> pp(NNode root,List<Integer> ret){
        if(root!=null){

            for(int i=0;i<root.children.size();i++){
                pp(root.children.get(i),ret);

            }
            ret.add(root.val);
        }
        return ret;
    }
    public List<Integer> postorder(NNode root) {
        List<Integer> ret=new ArrayList<>();
        if(root==null){
            return ret;
        }
        return pp(root,ret);
    }

    /**N叉树的前序遍历*/
    private List<Integer> pp1(NNode root,List<Integer> ret){
        if(root!=null){
            ret.add(root.val);
            for(int i=0;i<root.children.size();i++){
                pp(root.children.get(i),ret);

            }
        }
        return ret;
    }


    public List<Integer> perorder(NNode root) {
        List<Integer> ret=new ArrayList<>();
        if(root==null){
            return ret;
        }
        return pp1(root,ret);
    }
    /**N叉树的高度*/
    private int maxDepth(NNode root) {
        if(root==null){
            return 0;
        }
        int height=0;
        for(int i=0;i<root.children.size();i++){
            int h=maxDepth(root.children.get(i));
            if(h>height){
                height=h;
            }
        }
        return height+1;
    }

//    public List<List<Integer>> levelOrder(NNode root) {
//        List<List<Integer>> ret = new ArrayList<>();
//        if(root == null){
//            return ret;
//        }
//        Queue<NNode> q = new LinkedList<>();
//        q.offer(root);
//        while(!q.isEmpty()){
//            int size = q.size();
//            List<Integer> l = new ArrayList<>();
//            for(int i = 0;i < size; i++){
//                NNode node=q.poll();
//                l.add(node.val);
//                for(int j=0;j<node.children.size();j++){
//                    if(node.children.get(j)!=null){
//                        q.offer(node.children.get(j));
//                    }
//                }
//            }
//            ret.add(l);
//        }
//        return ret;
//
//    }



}
