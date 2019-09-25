package life.dakuzai.community.community.model;

import lombok.Data;

/**
 * @ClassName User
 * @Author admin
 * @Date 2019/9/18 14:58
 **/
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;
}
