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
import uestc.model.entity.dao.User;
import uestc.model.entity.vo.ResetPassword;
import uestc.model.entity.vo.UserVo;
import uestc.model.service.UserService;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;


    @ResponseBody
    @RequestMapping(value = "/register.do", method = RequestMethod.POST)
    public ResponseTemplate register(@RequestBody User user) {
        return userService.register(user);
    }

    @ResponseBody
    @RequestMapping(value = "/check_valid.do", method = RequestMethod.POST)
    public ResponseTemplate check_valid(@RequestBody User user) {
        System.out.println(user.getEmail());
        return userService.checkEmailValid(user.getEmail());
    }

    /*
    登录会存储登录状态以及email
     */
    @ResponseBody
    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public ResponseTemplate login(@RequestBody User user, HttpServletRequest request) {
        boolean result = userService.loginCheck(user.getEmail(), user.getPassword());
        if (result == false)
            return new ResponseTemplate(0, "邮箱或密码错误", null);
        else {
            HttpSession session = request.getSession();
            session.setAttribute(Constvar.USERSTATUS, Constvar.USER);
            session.setAttribute(Constvar.USEEMAIL, user.getEmail());

            return new ResponseTemplate(1, "登陆成功", new String(user.getEmail()));
        }
    }

    @ResponseBody
    @RequestMapping(value = "/vilidate.do", method = RequestMethod.GET)
    public ResponseTemplate vilidate() {
        return new ResponseTemplate();
    }

    @ResponseBody
    @RequestMapping(value = "/get_user_info.do", method = RequestMethod.GET)
    public ResponseTemplate get_user_info(HttpServletRequest request) {
        boolean loginStatus =
                StringUtils.equals((String) request.getSession().getAttribute(Constvar.USERSTATUS), Constvar.USER);
        if (loginStatus == false)
            return new ResponseTemplate(0, "用户未登录，请登录", null);
        else {
            String email = (String) request.getSession().getAttribute(Constvar.USEEMAIL);
            return new ResponseTemplate(1, "SUCCESS", userService.getUserInfo(email));
        }
    }

    @ResponseBody
    @RequestMapping(value = "/forget_get_question.do", method = RequestMethod.POST)
    public ResponseTemplate forget_get_question(@RequestBody UserVo userVo) {
        if (userService.checkEmail(userVo.getEmail()) == true)
            return new ResponseTemplate(0, "用户名不存在", null);
        else {
            String question = userService.getUserInfo(userVo.getEmail()).getQuestion();
            return new ResponseTemplate(1, "", question);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/forget_check_answer.do", method = RequestMethod.POST)
    public ResponseTemplate forget_check_answer(@RequestBody User user, HttpServletRequest request) {
        boolean result = userService.chechQuestionAndAnswer(user.getEmail(), user.getQuestion(), user.getAnswer());
        if (result == false)
            return new ResponseTemplate(0, "密保答案错误", null);
        else {
            String token = UUID.randomUUID().toString();
            HttpSession session = request.getSession();
            session.setAttribute(Constvar.TOKEN, token);
            return new ResponseTemplate(1, "", new String(token));
        }
    }

    @ResponseBody
    @RequestMapping(value = "/forget_reset_password.do", method = RequestMethod.POST)
    public ResponseTemplate forget_reset_password(@RequestBody ResetPassword resetPassword, HttpServletRequest request) {
        String sessionToken = (String) request.getSession().getAttribute(Constvar.TOKEN);
        boolean result = StringUtils.equals(sessionToken, resetPassword.getToken());
        if (result == false)
            return new ResponseTemplate(0, "修改密码失败", null);
        else {
            userService.resetPassword(resetPassword.getEmail(), resetPassword.getNewpassword());
            return new ResponseTemplate(1, "修改密码成功", null);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/reset_password.do", method = RequestMethod.POST)
    public ResponseTemplate reset_password(@RequestBody ResetPassword resetPassword, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute(Constvar.USEEMAIL);
        userService.resetPassword(email, resetPassword.getNewpassword());
        return new ResponseTemplate(1, "修改密码成功", null);
    }

    @ResponseBody
    @RequestMapping(value = "/update_information.do", method = RequestMethod.POST)
    public ResponseTemplate update_information(@RequestBody User user, HttpServletRequest request) {
        String email = (String) request.getSession().getAttribute(Constvar.USEEMAIL);
        //todo
        user.setEmail(email);
        userService.update(user);
        return new ResponseTemplate(1, "修改信息成功", null);

    }

    @ResponseBody
    @RequestMapping(value = "/logout.do", method = RequestMethod.GET)
    public ResponseTemplate logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute(Constvar.USERSTATUS);
        return new ResponseTemplate(1, "注销成功", null);
    }

}
