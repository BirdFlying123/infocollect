package uestc.model.service;

import uestc.model.entity.vo.CategoryIdInfo;

import java.util.List;

public interface CategoryService {
//    int addCategory(String id, String name);
//    int deleteCategory(String id);
//    int updateCategory(String id,String name);
//
//    CategoryIdInfo getNameById();
//    获得所有分类信息
    List<CategoryIdInfo> selectAll();
//根据活动名称查出id
    int getIdByActivityName(String name);
}
