//线程池  数据库连接池   常量池


//反射：java的自省  拿到当前类所有的私有的东西  类的所有东西变为公开的
//类信息存放在方法区

import java.lang.reflect.Field;

public class TestDemo {
    public static boolean fun(String str){
        char[] array=str.toCharArray();

        int i=0;
        for (; i<array.length ; i++) {
            if(array[i]>'9'||array[i]<'0'){
                     return false;
            }
        }
        return true;
    }
public static boolean fun1(String str){
    for (int i = 0; i < str.length(); i++) {
        if(str.charAt(i)>'9'||str.charAt(i)<'0'){
            return false;
        }

    } return true;
}
    //final int a=2;//  在 堆山上
    public static void main(String[] args) {
        char[] array={'a', 'b', 'c'};

        String str1=new String(array,1,2);
        System.out.println(str1);
    }
    public static void main7(String[] args) throws NoSuchFieldException,IllegalArgumentException,IllegalAccessException{
        String str="hello";
        Class cls=String.class;//得到string的类信息
        //反射：java的自省  拿到当前类所有的私有的东西  类的所有东西变为公开的
        Field filed=cls.getDeclaredField("value");
        filed.setAccessible(true);
        char[] value=(char[]) filed.get(str);
        System.out.println(value);
    }
    public static void main6(String[] args) {
        String str="Hello";
        str="h"+str.substring(1);//提取一个子串：从1号下标开始提取
    }
    public static void main5(String[] args) {
        char[] array={'a', 'b', 'c'};
        String str="abc";
        String str1=new String(array).intern();///在常量池中找absdif (1)存在 返回地址  （2）不存在 生成字符串的引用
        System.out.println(str==str1);
    }

    public static void main4(String[] args) {
        String str="absdjf";
        String str1=new String("absdjf").intern();///在常量池中找absdif (1)存在 返回地址  （2）不存在 生成字符串的引用
        System.out.println(str==str1);
    }




    public static void main3(String[] args) {
        final int a=2; //在栈上
        String str="absdjf";
        String str1="sjkck";
        System.out.println(str.compareTo(str1));//str>str1  >0

    }
    public static void main2(String[] args) {

        String str="abc"+"def"+360;//只有一个对象 "abcdef360"  常量
        int a=55;
        String str1="abc"+a;//两个对象

    }
    public static void main1(String[] args) {
        String str = "abcdef";//在堆里的常量池  只要是双引号因上的值都在常量池
        //常量池已经存在abcdef中  abcdef就不能再次到常量池中
        System.out.println(str);

        String str2 = new String("abcdef");//str2=abcdef
        System.out.println(str2);

        char[] arr = {'a', 'b', 'c'};  //abcdef在堆里  一个数组对象
        String str3 = new String(arr);
        System.out.println(str3);
        String str4 = "abc" + "def";//在编译期间已经确定字符串
        //常量的特性：编译期间已经被处理
        System.out.println(str == str2);
        System.out.println(str == str3);
        System.out.println(str == str4);//true
        String str5 = "abc" + new String("def");
        System.out.println(str == str5);//false
        String str6="abc";
        String str7="def";
        String str8=str6+str7;
        System.out.println(str==str8);//false    str 和str8是变量  在编译期间不会将字符串拼接起来
    }

}
