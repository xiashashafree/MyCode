package free.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Setter
@Getter
@ToString
public class User {
    private String username;
    private String password;
    private Date birthday;
}
