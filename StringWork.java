import java.util.Arrays;

public class StringWork {

    public boolean isLongPressedName(String name, String typed) {
        int j = 0;
        for (char c: name.toCharArray()) {
            if (j == typed.length())
                return false;

            // If mismatch...
            if (typed.charAt(j) != c) {  //j是指一个块中 字符的下标
                // If it's the first char of the block, ans is false.
                if (j==0 ||
                        //s1:aaabb   s2:aabb
                        // j已经在s2的第一个b上，已经来到typed的下一个块，
                        // 但此时这个typed 块的区域小于name中的块
                        //j-1是上一个块中的字符
                        typed.charAt(j-1) != typed.charAt(j))
                    return false;

                // Discard all similar chars  丢弃掉所有相同的字母
                char cur = typed.charAt(j);
                while (j < typed.length() && typed.charAt(j) == cur)
                    j++;

                // If next isn't a match, ans is false.
                if (j == typed.length() || typed.charAt(j) != c)
                    return false;
            }

            j++;
        }

        return true;

    }


    //非原地修改
    public static int compress(char[] chars) {

        //存储压缩结果
        char[] res = new char[chars.length];

        int index = 0;//标记res写进的下标
        for (int i = 0; i < chars.length; ) {
            int count = 0;

            char ch = chars[i];
            while (i < chars.length && ch == chars[i]) {
                //字符重复次数
                count++;
                i++;
            }

            //写进压缩结果
            if (count >= 10) {
                res[index++] = ch;
                res[index++] = 1 + '0';
                res[index++] = (char) (count - 10 + '0');
            } else if (count > 1) {
                res[index++] = ch;
                res[index++] = (char) (count + '0');
            } else {
                res[index++] = ch;
            }
        }

        //返回res的新长度
        return index;
    }

    //原地压缩
    public static int compress1(char[] chars) {
        int ch=0;
        int write=0;//记录更新区域的下标

        for (int i = 0; i < chars.length ; i++) {
            if(i+1==chars.length|| chars[i+1]!=chars[i]){

                //写进要压缩的字符
                chars[write++]=chars[ch];

                //当当前字符个数大于1时写进字符个数
                if(i>ch){
                    for ( char c  :  (""+(i-ch+1)).toCharArray()
                         ) {
                        chars[write++]=c;
                    }
                }
                //更新当前要压缩的字符
                ch=i+1;
            }
        }

        return write;
    }


    public static void main(String[] args) {

        char [] ch={'a','a','b','b','c','c','c'};
         compress1(ch);


    }
}
