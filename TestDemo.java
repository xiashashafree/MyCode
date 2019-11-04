import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Xia
 * Date: 2019-10-27
 * Time: 11:12
 */
class MyArrayList {
    public int usedSize;
    public int[] elem;

    public  final int CAPACITY = 10;

    public MyArrayList() {
        this.usedSize = 0;
        this.elem = new int[CAPACITY];
    }
    public boolean isFull(){
        return this.usedSize==this.elem.length;
    }
    public boolean isEmpty(){
        return this.usedSize==0;
    }
    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        if(isFull())
        {
            this.elem=Arrays.copyOf(this.elem,this.elem.length*2);
        }
        if(pos<0||pos>this.usedSize) {
            System.out.println("插入位置非法");
        }
        else{
            for(int i=usedSize-1;i>=pos;i--)
            {
                this.elem[i+1]=this.elem[i];
            }
        this.elem[pos]=data;
        this.usedSize++;
        }
        //1、pos是否合法
        //2、挪数据
        //3、插入数据
        //4、usedSize++
    }
    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for(int i=0;i<this.usedSize;i++){
            if(this.elem[i]==toFind){
                return true;
            }
        }
        return false;
    }
    // 查找某个元素对应的位置
    public int search(int toFind) {
        if(isEmpty()){
            System.out.println("列表为空");
            return -1;
        }

        for(int i=0;i<this.usedSize;i++){
            if(this.elem[i]==toFind){
                return i;

            }
        }
        return -1;
    }
    // 获取 pos 位置的元素
    public int getPos(int pos) {
        if(pos<0||pos>this.usedSize-1)
            return -1;

        return this.elem[pos];

    }


    // 获取顺序表长度
    public int size() {
        return this.usedSize;
    }
    // 清空顺序表
    public void clear() {
        this.usedSize=0;
    }
    public void remove(int toRemove) {
        int index=search(toRemove);
        if(index==-1){
            System.out.println("没有你要删除的数字");
        }
        for (int i = index; i < this.usedSize-1; i++) {
                this.elem[i]=this.elem[i+1];
                }
            this.usedSize--;
    }
    // 打印顺序
    public void display() {
        for(int i=0;i<this.usedSize;i++){
            System.out.println(this.elem[i]);
        }
    }
}
public class TestDemo{
    public static void main(String[] args) {
        MyArrayList a=new MyArrayList();
        a.add(0,1);
        a.add(1,2);
        a.add(2,3);
        a.add(3,4);
        a.display();
        a.search(3);
        a.remove(3);
        a.display();
    }
        }
