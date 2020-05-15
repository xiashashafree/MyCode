package unit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Article;
import org.junit.Test;

import java.util.Date;

public class JSONUtilTest {

    @Test
    public void t1(){
        try {
        ObjectMapper mapper = new ObjectMapper();
        Article article = new Article();
        article.setId(1);
        article.setTitle("wowowowo");
        article.setContent("你好啊啊");
        article.setUserId(1);
        article.setCreateTime(new Date());

        String s = null;

            s = mapper.writeValueAsString(article);
            System.out.println(s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


    }
}
