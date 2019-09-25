package life.dakuzai.community.community.service;

import life.dakuzai.community.community.dto.QuestionDto;
import life.dakuzai.community.community.mapper.QueationMapper;
import life.dakuzai.community.community.mapper.UserMapper;
import life.dakuzai.community.community.model.Question;
import life.dakuzai.community.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName QuestionService
 * @Author admin
 * @Date 2019/9/25 16:23
 **/
@Service
public class QuestionService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QueationMapper queationMapper;

    public List<QuestionDto> list() {
        List<Question> questions = queationMapper.list();
        List<QuestionDto> questionDtoList = new ArrayList<>();
        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDto questionDto = new QuestionDto();
            //将question里面的对象copy到questionDto里面
            BeanUtils.copyProperties(question,questionDto);
            questionDto.setUser(user);
            questionDtoList.add(questionDto);
        }
        return questionDtoList;
    }
}
