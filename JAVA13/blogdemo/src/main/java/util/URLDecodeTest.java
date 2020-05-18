package util;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

//http请求时：浏览器默认把url进行编码（中文/空格/特殊字符编码为ascii）
// request获取url中的参数时，如果是中文/特殊字符，需要手动解码
public class URLDecodeTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
       //编码
        URL url =URLDecodeTest.class.getClassLoader().getResource("Y o/随便.txt");

        System.out.println(url);
        //解码
        String path = URLDecoder.decode(url.getPath(),"UTF-8");
        System.out.println(path);
    }

}
