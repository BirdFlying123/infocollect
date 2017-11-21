package uestc.model.service;

import org.apache.ibatis.annotations.Param;
import uestc.common.ResponseTemplate;
import uestc.model.entity.dao.User;
import uestc.model.entity.vo.BackUserInfo;
import uestc.model.entity.vo.UserVo;

import java.util.List;

public interface UserService {
    //    查看所有用户信息
    public List<BackUserInfo> searchAllUser();

    //    修改用户验证状态
    public boolean changeStauts(int id);

    //    注册用户
    public ResponseTemplate register(User user);

    //检验邮箱是否合法
    public ResponseTemplate checkEmailValid(String email);

    //    检验邮箱是否存在
    public boolean checkEmail(String email);

    //    验证登录
    public boolean loginCheck(String email, String password);

    //    依据email查用户信息
    public UserVo getUserInfo(String email);

    //    验证密保
    public boolean chechQuestionAndAnswer(String email, String question, String answer);

    //    忘记密码重置密码
    public boolean forgetResetPassword(String email, String newpassword, String token);

    //    登录状态重置密码
    public boolean resetPassword(String email, String newpasword);

    //更新个人信息
    public boolean update(User user);

//    根据email获取用户信息
    public User getUserByEmail(@Param("email")String email);
}

