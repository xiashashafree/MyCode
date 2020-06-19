package free.controller;

import free.model.Article;
import free.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/query/{id}")
    public Object queryById(@PathVariable("id") Integer id){
        Article article=null;
        try {
            article = articleService.queryById(id);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }finally {
            return article;
        }
    }
}
