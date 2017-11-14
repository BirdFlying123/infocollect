package uestc.controller.foreground;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import uestc.common.Constvar;
import uestc.common.ResponseTemplate;
import uestc.model.service.ActivityService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user/manage")
public class UserActivityController {

    @Autowired
    @Qualifier("activityServiceImpl")
    private ActivityService activityService;

    @ResponseBody
    @RequestMapping("/list.do")
    public ResponseTemplate list(HttpServletRequest request){
        HttpSession session=request.getSession();
        if(StringUtils.isEmpty((String) session.getAttribute(Constvar.USERSTATUS)))
            return new ResponseTemplate(0,"未登录，请先登录",null);



    }
}
