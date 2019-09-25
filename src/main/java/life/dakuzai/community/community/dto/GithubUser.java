package life.dakuzai.community.community.dto;

import lombok.Data;

/**
 * @ClassName GithubUser
 * @Author admin
 * @Date 2019/9/17 10:11
 **/
@Data
public class GithubUser {
    private Long id;
    private String name;
    private String bio;
    private String avatar_url;
}
