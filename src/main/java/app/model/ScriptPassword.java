/*
 *Copyright © 2007-2018 DXY All Rights Reserved.
 */
package app.model;

import lombok.Data;
import org.hibernate.validator.constraints.ScriptAssert;

/**
 * @author maxcess since 2018/3/16
 * @e-mail mabin@dxy.cn
 */
@ScriptAssert(script = "_this.pwd1==_this.pwd2", lang = "javascript", alias = "_this", message = "两次密码不一致")
@Data
public class ScriptPassword {
    private String pwd1;
    private String pwd2;
}
