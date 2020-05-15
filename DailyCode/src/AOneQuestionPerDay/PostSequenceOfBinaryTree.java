package AOneQuestionPerDay;

public class PostSequenceOfBinaryTree {

    private boolean isPost(int[] arr,int left,int right){
        if(left>=right) return true;
        int i = left;
        //分辨左子树
        while(arr[i]<arr[right]){
            i++;
        }
        int mid = i;
        //分辨右子树
        while(arr[i]>arr[right]){
            i++;
        }
        //i == right 判断这棵树是否是树，前面已然确定了左子树和右子树
        //这时i按道理一定是根节点的下标，若不是，则说明这棵树不是树
        return i==right && isPost(arr,left,mid-1) && isPost(arr,mid,right-1);

    }
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0){
            return false;
        }
        return isPost(sequence,0,sequence.length-1);
    }

}


