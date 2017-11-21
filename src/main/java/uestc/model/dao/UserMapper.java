package uestc.model.dao;

import org.apache.ibatis.annotations.Param;
import uestc.model.entity.dao.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //    为管理员查询所有账户信息
    List<User> selectAll();

    //    查询邮箱
    int selectByEmail(@Param("email") String email);

    //    查找用户名密码是否一致
    int selectByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    //依据邮箱查找信息
    User selectUserByEmail(@Param("email") String email);

    //    检验密保问题
    boolean chechQuestionAndAnswer(@Param("email") String email, @Param("question") String question, @Param("answer") String answer);

    //    更新密码
    boolean updatePasswordByEmail(@Param("email") String email, @Param("password") String password);

    //依据email获取用户信息
    User selectPKByEmail(@Param("email") String email);


}