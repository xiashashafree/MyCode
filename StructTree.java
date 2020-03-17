import java.util.Scanner;
class TreeNode{
    char val;
    TreeNode left;
    TreeNode right;
    public TreeNode(char val){
        this.val=val;
    }
}
class Tree{
    private TreeNode root=null;
    public Tree(String s,char c){
        root=createTree(s,c);
        
    }
    int index=0;
    private TreeNode createTree(String s,char c){
        TreeNode root=null;
        if(index<s.length()&&s.charAt(index)!='#'){
            root=new TreeNode(s.charAt(index));
            index++;
            root.left=createTree(s,'#');
            index++;
            root.right=createTree(s,'#');
        }
        return root;
    }
    private void inorder(TreeNode root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.val+" ");
            inorder(root.right);
        }
    }
    public void inorder(){
        inorder(root);
        System.out.println();
    }
}
public class Main{
    public static void main(String[]  args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLine()){
            String s=sc.nextLine();
            Tree bt=new Tree(s,'#');
            bt.inorder();
        }
       
    }
}