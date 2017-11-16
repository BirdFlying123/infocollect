package uestc.model.dao;

import org.apache.ibatis.annotations.Param;
import uestc.model.entity.dao.Activity;

import java.util.List;

public interface ActivityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Activity record);

    int insertSelective(Activity record);

    Activity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);

    List<Activity> selectByUserId(Integer userid);

//    删除活动
    int delete(@Param("id")Integer id,@Param("userid") Integer userid);
//    查询所有活动
    List<Activity> selectAll(@Param("desc")String desc, @Param("startpage")Integer startpage,@Param("endpage")Integer endpage);
//依据categoryid查询所有活动
    List<Activity> selectAllByCategoryId(@Param("categoryid")Integer categoryid, @Param("startpage")Integer startpage,@Param("endpage")Integer endpage);

}