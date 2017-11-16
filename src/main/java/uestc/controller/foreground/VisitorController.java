package uestc.controller.foreground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import uestc.common.ResponseTemplate;
import uestc.model.entity.vo.ActivityVo;
import uestc.model.entity.vo.VisitorSearchVo;
import uestc.model.service.ActivityService;
import uestc.model.service.CategoryService;

import java.util.List;

@Controller
public class VisitorController {

    @Autowired
    @Qualifier("activityServiceImpl")
    private ActivityService activityService;

    @Autowired
    @Qualifier("categoryServiceImpl")
    private CategoryService categoryService;

    @ResponseBody
    @RequestMapping(value = "/function/search.do",method = RequestMethod.POST)
    public ResponseTemplate funcSearch(@RequestBody VisitorSearchVo visitorSearchVo) {
        System.out.println(visitorSearchVo);

        if (visitorSearchVo.getType().equals("content")) {
            //依据内容搜索
            List<ActivityVo> activityVos = activityService.listByDesc
                    (visitorSearchVo.getDesc(), visitorSearchVo.getPage(), visitorSearchVo.getPagesize());

            return new ResponseTemplate(1, "", activityVos);
        }
        if (visitorSearchVo.getType().equals("classfiy")) {

            int actegoryid = categoryService.getIdByActivityName(visitorSearchVo.getDesc());
            List<ActivityVo> activityVos = activityService.listByCategoryId
                    (new Integer(visitorSearchVo.getDesc()), visitorSearchVo.getPage(), visitorSearchVo.getPagesize());
            return new ResponseTemplate(1,"",activityVos);
        }
        return new ResponseTemplate(0,"请求错误",null);
    }
}
