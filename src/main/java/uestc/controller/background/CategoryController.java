package uestc.controller.background;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import uestc.common.ResponseTemplate;
import uestc.model.entity.vo.CategoryIdInfo;
import uestc.model.service.CategoryService;

import java.util.List;

@Controller
@RequestMapping("/user")
public class CategoryController {

    @Autowired
    @Qualifier("categoryServiceImpl")
    private CategoryService categoryService;

    @ResponseBody
    @RequestMapping(value = "/get_all_category.do", method = RequestMethod.GET)
    public ResponseTemplate get_all_category() {
        List<CategoryIdInfo> categoryIdInfos=categoryService.selectAll();
        return new ResponseTemplate(1,"",categoryIdInfos);
    }

}
