package uestc.model.dao;

import org.apache.ibatis.annotations.Param;
import uestc.model.entity.dao.Admin;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

//    检验登录信息
    int checkLogin(@Param("username")String username, @Param("password")String password);
}
