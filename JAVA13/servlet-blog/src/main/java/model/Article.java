package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Setter
@Getter
@ToString
public class Article {
    private int Id;
    private String title;
    private String content;
    private int UserId;
    private Date createTime;
}
