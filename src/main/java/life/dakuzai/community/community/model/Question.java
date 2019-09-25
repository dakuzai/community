package life.dakuzai.community.community.model;

import lombok.Data;

/**
 * @ClassName Question
 * @Author admin
 * @Date 2019/9/23 15:22
 **/
@Data
public class Question {
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
}
