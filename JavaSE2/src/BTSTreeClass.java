import java.util.Stack;

public class BTSTreeClass {
    private BTSNode root = null;

    public static class BTSNode {
        BTSNode left;
        BTSNode right;
        int val;

        public BTSNode(int val) {
            this.val = val;
        }
    }

    /***
     * 是否包含某值
     * @param val
     * @return
     */
    boolean contains(int val) {
        BTSNode cur = root;
        while (cur != null) {
            if (val == cur.val) {
                return true;
            } else if (val < cur.val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return false;
    }


    /***
     * 插入值
     * @param val
     * @return
     */
    boolean insertNode(int val) {
        BTSNode cur = root;
        BTSNode parent = null;
        while (cur != null) {
            parent = cur;
            if (cur.val == val) {
                return false;
            } else if (cur.val < val) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        if (parent == null) {
            root = new BTSNode(val);
        } else {
            if (parent.val > val) {
                parent.left = new BTSNode(val);
            } else {
                parent.right = new BTSNode(val);
            }
        }
        return true;
    }

    /***
     * 找到最小值
     * @return
     */
    int leftMost() {
        BTSNode cur = root;
        BTSNode parent = null;
        while (cur != null) {
            parent = cur;
            cur = cur.left;
        }
        if (parent == null) {
            return root.val;
        } else {
            return parent.val;
        }
    }

    /***
     * 找到最大值
     * @return
     */
    int rightMost() {
        BTSNode cur = root;
        BTSNode parent = null;
        while (cur != null) {
            parent = cur;
            cur = cur.right;
        }
        if (parent == null) {
            return root.val;
        } else {
            return parent.val;
        }
    }

    /***
     * 删除二叉搜索树的指定结点
     * @param val
     * @return
     */
    boolean deleteNode(int val) {
        BTSNode cur = root;
        BTSNode parent = null;
        while (cur != null) {
            if (cur.val == val) {
                break;
            } else if (cur.val < val) {
                parent = cur;
                cur = cur.right;
            } else {
                parent = cur;
                cur = cur.left;
            }
        }

        if (cur == null) {
            return false;
        }
        if (cur.left == null) {
            if (parent == null) {
                root = root.right;
            } else if (parent.left == cur) {
                parent.left = cur.right;
            } else {
                parent.right = cur.right;
            }
        } else if (cur.right == null) {
            if (parent == null) {
                root = root.left;
            } else if (parent.left == cur) {
                parent.left = cur.left;
            } else {
                parent.right = cur.left;
            }
        } else {
            //找替代结点：(1)去右子树里找最小的(2)去左子树里找最大结点
            //这里使用（1）
            BTSNode del = cur.right;
            parent = cur;
            while (del.left != null) {
                parent = del;
                del = del.left;
            }
            cur.val = del.val;
            if (parent.right == del) {
                parent.right = del.right;
            } else {
                parent.left = del.right;
            }
        }
        return true;
    }

    void inOrder() {
        inorderNor(root);
        System.out.println();
    }

    private void inOrder(BTSNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }
    private void inorderNor(BTSNode root){
        if(root == null) {
            return;
        }

        BTSNode cur = root;
        Stack<BTSNode> s =new Stack<>();

        while(cur != null || !s.empty()){
            if(cur != null){
                s.push(cur);
                cur=cur.left;
            }else{
                cur = s.pop();
                System.out.print(cur.val+" ");
                cur=cur.right;
            }
        }
    }

    /***
     * java.lang.NullPointerException
     *   at line 117, TreeNodeSerializer.isValid
     *   at line 144, TreeNodeSerializer.serialize
     *   at line 186, __Driver__.main
     * 将二叉搜索树转换为双向列表
     * @param args
     */

    BTSNode prev = null;
    public  void toLinked(){
        if(root == null){
            return ;
        }
        BTSNode head = root;

        while(head.left!=null){
            head = head.left;
        }
        toLinkedList(root);

        while(head != null){
            System.out.print(head.val+"--->");
            head = head.right;
        }
        System.out.println("NULL");


    }
    private void toLinkedList(BTSNode root){
        if(root != null){
            toLinkedList(root.left);
            root.left = prev;
            if(prev != null){
                prev.right = root;
            }
            prev = root;
            toLinkedList(root.right);
        }
    }

    public static void main(String[] args) {
        BTSTreeClass tree = new BTSTreeClass();
        int[] arr = {3, 4, 1, 6, 5, 2, 7, 8};
        for (int num : arr) {
            tree.insertNode(num);
        }
        tree.inOrder();

        tree.deleteNode(3);
        tree.inOrder();
        tree.toLinked();

    }
}
