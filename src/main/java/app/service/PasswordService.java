/*
 *Copyright © 2007-2018 DXY All Rights Reserved.
 */
package app.service;

import app.constraint.CrossParameter;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * @author maxcess since 2018/3/16
 * @e-mail mabin@dxy.cn
 */
@Validated
@Service
public class PasswordService {


    @CrossParameter
    public void changePassword(String password, String confirmation) {
        System.out.println("密码一致~");
    }
}
