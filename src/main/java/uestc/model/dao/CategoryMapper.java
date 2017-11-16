package uestc.model.dao;

import org.apache.ibatis.annotations.Param;
import uestc.model.entity.dao.Category;
import uestc.model.entity.vo.CategoryIdInfo2;

import java.util.List;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
//    查出子分类
    List<CategoryIdInfo2> selectIdByParent(int parentid);

//    依据id查出分类名称以及parentid
    CategoryIdInfo2 selectNameAndParentById(int id);

//    依据名称查出id号
    int getIdByName(@Param("name")String name);

}