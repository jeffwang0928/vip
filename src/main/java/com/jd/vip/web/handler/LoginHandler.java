package com.jd.vip.web.handler;


import com.jd.common.ThisSystemException;
import com.jd.vip.entity.UserEntity;
import com.jd.vip.function.UserFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class LoginHandler {

    @Autowired
    UserFunction userFunction;

    @RequestMapping("/login.do")
    public String login(String account, String password,HttpServletRequest request){
        try {
            UserEntity userEntity = userFunction.login(account,password);
            HttpSession session = request.getSession();
            session.setAttribute("currentUser",userEntity);
            System.out.println(userEntity);
        }catch (Exception e){
            request.setAttribute("message",e.getMessage());
            return "forward:/login.jsp";
        }
        System.out.println("redirect index.do");
        return "redirect:/index.do";
    }


    @RequestMapping("/index.do")
    public String index(){
        return "index";
    }

    @RequestMapping("/welcome.do")
    public String welcome(){
        return "welcome";
    }

    @RequestMapping("/logout.do")
    public String logout(HttpSession session){

        session.invalidate();
        return "redirect:/login.jsp";
    }

    @RequestMapping(method = RequestMethod.GET,path="/updatepassword.do")
    public String updatepasswordView(){
        return null;
    }
    @RequestMapping(method = RequestMethod.POST,path="/updatepassword.do")
    public String updatepassword(String oldPassword,String newPassword,String newPasswordConfirm,HttpServletRequest request)throws Exception{
        HttpSession session = request.getSession();
        UserEntity userEntity = (UserEntity) session.getAttribute("currentUser");
        try{
            userFunction.updatePassword(userEntity.getId(),oldPassword,newPassword,newPasswordConfirm);
        }catch (ThisSystemException e){
            request.setAttribute("message",e.getMessage());
            return "updatepassword";
        }
        session.setAttribute("message","修改成功，请重新登录!");
        return "redirect:/login.jsp";
    }
}
