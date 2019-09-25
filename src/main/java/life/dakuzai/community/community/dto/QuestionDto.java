package life.dakuzai.community.community.dto;

import life.dakuzai.community.community.model.User;
import lombok.Data;

/**
 * @ClassName QuestionDto
 * @Author admin
 * @Date 2019/9/25 16:25
 **/
@Data
public class QuestionDto {
    private Integer id;
    private String description;
    private String title;
    private String tags;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer compentCount;
    private Integer likeCount;
    private User user;
}
