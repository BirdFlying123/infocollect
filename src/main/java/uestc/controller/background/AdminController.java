package uestc.controller.background;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import uestc.common.Message;
import uestc.model.entity.vo.BackUserInfo;
import uestc.model.service.AdminService;
import uestc.model.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    @Qualifier("adminServiceImpl")
    private AdminService adminService;

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @RequestMapping(value = "/login.do", method = RequestMethod.GET)
    public String login_get() {
        return "login.jsp";
    }

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public String login_post(@RequestParam("username") String username, @RequestParam("password") String password,
                             HttpServletRequest request, HttpServletResponse response) {
        boolean result = adminService.valid(username, password);
        if (result == true){
            HttpSession session= request.getSession();
            session.setAttribute("role", Message.SUCCESSLOGIN);
           return "manage.jsp";
        }

        request.setAttribute("loginMessage", Message.LOGINMESSAGE);
        return "login.jsp";
    }

    @RequestMapping(value = "/list_user.do",method = RequestMethod.GET)
    public String list(HttpServletRequest request){
        HttpSession session=request.getSession();
        String role= ((Message) session.getAttribute("role")).getDesc();
        System.out.println(role);
        if(StringUtils.equals(role,Message.SUCCESSLOGIN.getDesc()))
        {
        List<BackUserInfo> backUserInfos= userService.searchAllUser();
        request.setAttribute("backUserInfos",backUserInfos);
        return "list.jsp";
        }
        return "login.jsp";

    }

    @RequestMapping(value = "/change/{id}",method = RequestMethod.GET)
    public String changeStatus(HttpServletRequest request,@PathVariable("id")Integer id){
        //todo
        userService.changeStauts(id);
        List<BackUserInfo> backUserInfos= userService.searchAllUser();
        request.setAttribute("backUserInfos",backUserInfos);
        return "list.jsp";
    }
}
