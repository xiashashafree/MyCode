
public class Review {
    public static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val = val;
        }
    }

    private Node root = null;

    //是否包含某个值
    public  boolean contains(int val){
        if(root == null){
            return false;
        }
        Node cur = root;
        while(cur!=null){
            if(cur.val>val){
                cur =cur.left;
            }else if(cur.val<val){
                cur=cur.right;
            }else{
                return true;
            }
        }
        return false;
    }

    //添加一个结点
    public boolean add(int val){

        Node parent = null;
        Node cur = root;
        while(cur!=null){

            if(cur.val>val){
                parent = cur;
                cur = cur.left;
            }else if(cur.val<val){
                parent = cur;
                cur =cur.right;
            }else{
                return false;
            }
        }
        if(parent == null){
            root = new Node(val);
        }else{
            if(parent.val<val){
                parent.right = new Node(val);
            }else{
                parent.left = new Node(val);
            }
        }
        return true;
    }

    //删除一个结点
    public boolean delete(int val){
        if(root == null){
            return false;
        }


        Node parent = null;
        Node cur = root;

        while(cur!= null){
            //不能讲 parent =cur 放在这里
            if(cur.val<val){
                parent = cur;
                cur = cur.right;
            }else if(cur.val>val){
                parent = cur;
                cur =cur.left;
            }else{
                break;
            }
        }
        //没有此值
        if(cur == null){
            return false;
        }

        //待删除的结点没有左子树
        if(cur.left == null){

            if(parent == null){
                //待删除结点为根节点
                root = null;//待删除结点是根节点
            }else{

                if(parent.left == cur){//待删除结点位于左子树
                    parent.left = cur.right;
                }else{//待删除结点位于右子树
                    parent.right = cur.right;
                }
            }
        }else if(cur.right == null){//待删除结点没有右子树
            if(parent == null){ //待删除结点为根节点
                root = null;
            }else {
                if(parent.left == cur){//待删除结点位于左子树
                    parent.left = cur.left;
                }else{//待删除结点位于右子树
                    parent.right = cur.left;
                }
            }
        }else {
            //待删除结点有左子树和右子树  在其右子树中找一个最小的结点代替它，将两值交换，删除代替结点
//           Node del = cur.right;
//           parent = cur;
//           while(del.left!=null){
//               parent = cur;
//               del =del.left;
//           }
//           cur.val = del.val;
//           if(parent.right == del){
//               cur.right = del.right;
//           }else{
//               parent.left = del.right;
//           }
            Node del = cur.left;
            parent = cur;
            while(del.right!=null){
                parent = del;
                del=del.right;
            }
            cur.val = del.val;
            if (del == parent.left) {
                parent.left = del.left;
            }else{
                parent.right = del.left;
            }
        }
        return true;

    }

}
