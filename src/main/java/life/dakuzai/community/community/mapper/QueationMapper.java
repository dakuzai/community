package life.dakuzai.community.community.mapper;

import life.dakuzai.community.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName QueationMapper
 * @Author admin
 * @Date 2019/9/23 15:15
 **/
@Mapper
public interface QueationMapper {
    @Insert("insert into question (title,description,gmt_create,gmt_modified,creator,tags) values (#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tags})")
    void create(Question question);
    @Select("select * from question")
    List<Question> list();
}
