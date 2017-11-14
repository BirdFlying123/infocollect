package uestc.model.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import uestc.common.ResponseTemplate;
import uestc.model.dao.UserMapper;
import uestc.model.entity.dao.User;
import uestc.model.entity.vo.BackUserInfo;
import uestc.model.entity.vo.UserVo;
import uestc.model.service.UserService;
import uestc.utils.Convert;
import uestc.utils.MD5Util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("userMapper")
    private UserMapper userMapper;

    //convert
    public List<BackUserInfo> searchAllUser() {
        List<User> users = userMapper.selectAll();
        List<BackUserInfo> backUserInfos = new ArrayList<BackUserInfo>();
        if (users == null)
            return null;
        for (User user : users) {
            BackUserInfo backUserInfo = new BackUserInfo();

            backUserInfo.setCreatetime(user.getCreatetime());
            backUserInfo.setEmail(user.getEmail());
            backUserInfo.setId(user.getId().toString());
            backUserInfo.setIfChecked(Convert.getString(user.getIfchecked()));
            backUserInfo.setInstitution(user.getInstitution());

            backUserInfos.add(backUserInfo);
        }
        return null;
    }

    //need convert
    public boolean changeStauts(int id) {
        User user = userMapper.selectByPrimaryKey(id);
        if (user.getIfchecked() == 1) {
            User user1 = new User();
            user1.setIfchecked(0);
            userMapper.updateByPrimaryKeySelective(user1);
            return true;
        } else {
            User user1 = new User();
            user1.setIfchecked(1);
            userMapper.updateByPrimaryKeySelective(user1);
            return false;
        }
    }

    public ResponseTemplate register(User user) {
        boolean result = checkEmail(user.getEmail());
        if (result == false)
            return new ResponseTemplate(0, "邮箱已存在", null);

        user.setCreatetime(new Date());
        user.setIfchecked(0);
        user.setUpdatetime(new Date());
        user.setRole(0);
        user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));

        userMapper.insert(user);
        return new ResponseTemplate(1, "注册成功", user);
    }

    public ResponseTemplate checkEmailValid(String email) {
        boolean result = checkEmail(email);
        System.out.println(result+"......."+(result==false));
        if (result == false)
            return new ResponseTemplate(0, "邮箱已存在", null);
        return new ResponseTemplate(1, "SUCCESS", null);
    }

    public boolean checkEmail(String email) {
        if (userMapper.selectByEmail(email) != 0)
            return false;
        return true;
    }

    @Override
    public boolean loginCheck(String email, String password) {
        password = MD5Util.MD5EncodeUtf8(password);
        int count = userMapper.selectByEmailAndPassword(email, password);
        if (count == 1)
            return true;
        return false;
    }

    @Override
    public UserVo getUserInfo(String email) {
        User user = userMapper.selectUserByEmail(email);
        UserVo userVo = new UserVo();

        userVo.setId(user.getId());
        userVo.setEmail(user.getEmail());
        userVo.setAnswer(user.getAnswer());
        userVo.setInstitution(user.getInstitution());
        userVo.setQuestion(user.getQuestion());

        return userVo;
    }

    @Override
    public boolean chechQuestionAndAnswer(String email, String question, String answer) {
        return userMapper.chechQuestionAndAnswer(email, question, answer);
    }

    @Override
    public boolean forgetResetPassword(String email, String newpassword, String token) {
        return false;
    }

    @Override
    public boolean resetPassword(String email, String newpasword) {
        return userMapper.updatePasswordByEmail(email, MD5Util.MD5EncodeUtf8(newpasword));
    }

    @Override
    public boolean update(User user) {

        if (StringUtils.isEmpty(user.getPassword()))
            user.setEmail(null);
        if (StringUtils.isEmpty(user.getInstitution()))
            user.setInstitution(null);
        if (StringUtils.isEmpty(user.getQuestion()))
            user.setQuestion(null);
        if (StringUtils.isEmpty(user.getAnswer()))
            user.setAnswer(null);

        user.setRole(null);
        user.setIfchecked(null);
        user.setUpdatetime(new Date());
        user.setCreatetime(null);
        user.setId(userMapper.selectPKByEmail(user.getEmail()));

        userMapper.updateByPrimaryKeySelective(user);
        return false;
    }
}
