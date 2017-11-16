package uestc.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import uestc.model.dao.CategoryMapper;
import uestc.model.entity.vo.CategoryIdInfo;
import uestc.model.entity.vo.CategoryIdInfo2;
import uestc.model.service.CategoryService;


import java.util.ArrayList;
import java.util.List;

@Component("categoryServiceImpl")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    @Qualifier("categoryMapper")
    private CategoryMapper categoryMapper;

    @Override
    public List<CategoryIdInfo> selectAll() {
        List<CategoryIdInfo> categoryIdInfos = new ArrayList<>();
        //1.查出所有一级分类
        List<CategoryIdInfo2> categoryIdInfo2s = categoryMapper.selectIdByParent(0);

        for (CategoryIdInfo2 categoryIdInfo2 : categoryIdInfo2s) {

            //2.遍历一级分类，查出二级分类
            List<CategoryIdInfo2> categoryIdInfo2s1 = categoryMapper.selectIdByParent(categoryIdInfo2.getId());

            //创建一个一级分类的元素，并加入最终结果集
            CategoryIdInfo categoryIdInfo=new CategoryIdInfo();

            categoryIdInfo.setId(categoryIdInfo2.getId());//id
            categoryIdInfo.setDesc(categoryIdInfo2.getDesc());//desc
            categoryIdInfo.setCategoryIdInfo2s(categoryIdInfo2s1);//二级分类信息

            categoryIdInfos.add(categoryIdInfo);//加入结果集
        }
        return categoryIdInfos;
    }

    @Override
    public int getIdByActivityName(String name) {
        return categoryMapper.getIdByName(name);
    }

}
