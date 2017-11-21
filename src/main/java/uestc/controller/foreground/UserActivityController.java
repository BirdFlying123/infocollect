package uestc.controller.foreground;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import uestc.common.Constvar;
import uestc.common.ResponseTemplate;
import uestc.model.entity.dao.Activity;
import uestc.model.entity.dao.User;
import uestc.model.entity.vo.ActivityDetailVo;
import uestc.model.entity.vo.ActivityVo;
import uestc.model.service.ActivityService;
import uestc.model.service.CategoryService;
import uestc.model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/user/manage")
public class UserActivityController {

    @Autowired
    @Qualifier("activityServiceImpl")
    private ActivityService activityService;

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @Autowired
    @Qualifier("categoryServiceImpl")
    private CategoryService categoryService;

    @ResponseBody
    @RequestMapping(value = "/list.do", method = RequestMethod.POST)
    public ResponseTemplate list(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute(Constvar.USEEMAIL);

        User user= userService.getUserByEmail(email);
        if(user.getIfchecked().toString().equals("0"))
            return new ResponseTemplate(0,"请先通过验证",null);


        if (StringUtils.isEmpty(email))
            return new ResponseTemplate(0, "未登录，请先登录", null);

        List<ActivityVo> activityVos = activityService.listByEmail(email);
        return new ResponseTemplate(1, "", activityVos);
    }

    @ResponseBody
    @RequestMapping(value = "/search.do", method = RequestMethod.POST)
    public ResponseTemplate search(@RequestBody Activity activity,HttpServletRequest request) {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute(Constvar.USEEMAIL);

        User user= userService.getUserByEmail(email);
        if(user.getIfchecked().toString().equals("0"))
            return new ResponseTemplate(0,"请先通过验证",null);

        ActivityDetailVo activityDetailVo = activityService.search(activity.getId());

        return new ResponseTemplate(1, "", activityDetailVo);
    }

    @ResponseBody
    @RequestMapping(value = "/alter.do", method = RequestMethod.POST)
    public ResponseTemplate alter(@RequestBody ActivityDetailVo activityDetailVo,HttpServletRequest request) {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute(Constvar.USEEMAIL);

        User user= userService.getUserByEmail(email);
        if(user.getIfchecked().toString().equals("0"))
            return new ResponseTemplate(0,"请先通过验证",null);


        int categoryid = categoryService.getIdByActivityName(activityDetailVo.getLable());
        activityDetailVo.setCategoryid(categoryid);
        int row = activityService.update(activityDetailVo);
        if(row==0)
            return new ResponseTemplate(0,"修改失败",null);
        return new ResponseTemplate(1,"修改成功",null);
    }

    @ResponseBody
    @RequestMapping(value = "/delete.do", method = RequestMethod.POST)
    public ResponseTemplate delete(@RequestBody Activity activity, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute(Constvar.USEEMAIL);
        User user= userService.getUserByEmail(email);
        if(user.getIfchecked().toString().equals("0"))
            return new ResponseTemplate(0,"请先通过验证",null);


        int userid = userService.getUserByEmail(email).getId();
        int number = activityService.delete(activity.getId(), userid);
        if (number == 0) {
            return new ResponseTemplate(0, "删除失败", null);
        }
        return new ResponseTemplate(1, "删除成功", null);
    }

    @ResponseBody
    @RequestMapping(value = "/add.do", method = RequestMethod.POST)
    public ResponseTemplate add(@RequestBody ActivityDetailVo activityDetailVo, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute(Constvar.USEEMAIL);
        User user= userService.getUserByEmail(email);
        if(user.getIfchecked().toString().equals("0"))
            return new ResponseTemplate(0,"请先通过验证",null);



        if (StringUtils.isEmpty(email))
            return new ResponseTemplate(0, "未登录，请登录", null);

        int userid = userService.getUserByEmail(email).getId();
        int categoryid = categoryService.getIdByActivityName(activityDetailVo.getLable());
        activityDetailVo.setUserid(userid);
        activityDetailVo.setCategoryid(categoryid);
        int id = activityService.addActivity(activityDetailVo);
        return new ResponseTemplate(1, "", id);
    }



}
