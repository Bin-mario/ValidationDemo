/*
 *Copyright © 2007-2018 DXY All Rights Reserved.
 */
package app.model;

import app.constraint.CheckPassword;
import lombok.Data;

/**
 * @author maxcess since 2018/3/16
 * @e-mail mabin@dxy.cn
 */
@Data
@CheckPassword
public class Password {
    private String pwd1;
    private String pwd2;
}
