package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class JSONUtil {
    //单例模式创建ObjectMapper对象
    //双重校验锁
    private static volatile ObjectMapper MAPPER;
    public static ObjectMapper get(){
        if(MAPPER == null){
            synchronized (ObjectMapper.class){
                if(MAPPER == null){
                    MAPPER = new ObjectMapper();
                }
            }
        }
        return MAPPER;
    }

    /**
     * java对象序列化为json对象
     * @param o 对象
     * @return json字符串
     */
    public static String serialize(Object o) {
        try {
            return get().writeValueAsString(o);
        } catch (JsonProcessingException e) {//编译时异常转化为运行时异常
           throw new RuntimeException("JSON序列化失败，对象为："+o,e);
        }


    }

    /**
     * 将json字符串反序列化为java对象
     * @param json 字符串
     * @param clazz 具体的java类对象
     * @param <T> 泛型
     * @return
     */
    public static <T> T deserialize(String json,Class<T> clazz){
        try {
            return get().readValue(json,clazz);
        } catch (IOException e) {
            throw new RuntimeException("JSON反序列化失败，对象为："+json,e);
        }
    }

    public static <T> T deserialize(InputStream is, Class<T> clazz){
        try {
            return get().readValue(is,clazz);
        } catch (IOException e) {
            throw new RuntimeException("JSON反序列化失败",e);
        }
    }

}
