/*
 *Copyright © 2007-2018 DXY All Rights Reserved.
 */
package app.model;

import app.group.First;
import app.group.Second;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.validation.GroupSequence;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

/**
 * @author maxcess since 2018/3/15
 * @e-mail mabin@dxy.cn
 */
@Data
@GroupSequence({First.class, Second.class,UserGroupSequence.class})
public class UserGroupSequence {
    private Long id;
    @Length(min = 5, max = 20, message = "{user.name.length.illegal}", groups = {First.class})
    @Pattern(regexp = "[a-zA-Z]{5,20}", message = "{user.name.illegal}", groups = {Second.class})
    private String name;
    @Min(value = 18, message = "年龄不能小于18岁")
    private Integer age;
    @Email(message = "邮箱格式错误")
    private String email;
}
