package AOneQuestionPerDay;
public class 把数组排成最小数 {
    private int partion(String[] str,int left,int right){
        int l = left;
        int r = right-1;
        String temp = str[right-1];
        while(l<r){
            while(l<r && (str[l]+temp).compareTo(temp+str[l])<=0 ){
                l++;
            }
            while(l<=r && (str[r]+temp).compareTo(temp+str[r])>=0 ){
                r--;
            }
            if(l<r){
                String swap = str[l];
                str[l] = str[r];
                str[r] = swap;
            }
        }
        if(l!=right-1){
            String swap = str[l];
            str[l] = str[right-1];
            str[right-1] = swap;
        }
        return l;
    }
    public  void quickSort(String[] array,int left,int right){
        if(right - left >1){
            int div = partion(array, left, right);
            quickSort(array, left, div);
            quickSort(array, div + 1, right);
        }
    }
    public String minNumber(int[] nums) {
        String[] str = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            str[i] = nums[i]+"";
        }
        quickSort(str,0,str.length);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length;i++){
            sb.append(str[i]);
        }
        return sb.toString();
    }
}