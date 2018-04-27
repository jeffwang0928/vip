package com.jd.vip.function.impl;

import com.jd.common.ThisSystemException;
import com.jd.common.ThisSystemUtil;
import com.jd.vip.dao.UserDao;
import com.jd.vip.entity.UserEntity;
import com.jd.vip.function.UserFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.jd.common.AssertThrowUtil.*;

import static com.jd.common.AssertThrowUtil.$;

@Service
public class UserFunctionImpl implements UserFunction {

    @Autowired
    UserDao userDao;

    @Override
    public UserEntity login(String account, String password) throws Exception {
        /*
        if(account==null || account.trim().length()==0){

        }
        if(password==null || password.trim().length()==0){

        }
        */

        account=$("账号不能为空",account);
        password=$("密码不能为空",password);
        UserEntity userEntity= (UserEntity) userDao.select("account",account);
        if(userEntity==null){
            throw new ThisSystemException("账户不存在");
        }
        password = ThisSystemUtil.md5(password);
        if (!userEntity.getPassword().equals(password)){
            throw new ThisSystemException("密码错误");
        }
        return userEntity;
    }

    @Override
    public UserEntity updatePassword(String id,String oldPassword, String newPassword, String newPasswordConfirm) throws Exception {
        //验证参数
        id=$("id不能为空",id);
        oldPassword=$("旧密码不能为空",oldPassword);
        newPassword=$("新密码不能为空",newPassword);
        newPasswordConfirm=$("确认密码不能为空",newPasswordConfirm);
        System.out.println(newPassword+"_"+newPasswordConfirm);
        assertEquals("两次密码输入不一致",newPassword,newPasswordConfirm);
        assertNotEquals("新旧密码不能一样",oldPassword,newPassword);
        //找到用户
        UserEntity userEntity = userDao.select("id",id);
        assertNotNull("无法找到用户",userEntity);
        //验证旧密码
        oldPassword = ThisSystemUtil.md5(oldPassword);
        assertEquals("旧密码不正确", userEntity.getPassword(),oldPassword);
        //更新密码
        newPassword = ThisSystemUtil.md5(newPassword);
        userEntity.setPassword(newPassword);
        userDao.update(userEntity);

        return null;
    }
}
