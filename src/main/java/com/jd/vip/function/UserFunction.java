package com.jd.vip.function;

import com.jd.vip.entity.UserEntity;
import org.springframework.transaction.annotation.Transactional;

public interface UserFunction {
    public UserEntity login(String account,String password)throws Exception;

    @Transactional
    public UserEntity updatePassword(String id,String oldPassword,String newPassword,String newPasswordConfirm)throws  Exception;
}
