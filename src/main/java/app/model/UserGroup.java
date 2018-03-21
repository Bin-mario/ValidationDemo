/*
 *Copyright © 2007-2018 DXY All Rights Reserved.
 */
package app.model;

import app.group.Add;
import app.group.Update;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

/**
 * @author maxcess
 * @since 2018/2/27
 * if you have any problem  please send to mabin@dxy.cn
 */
@Data
public class UserGroup {
    @NotBlank(groups = {Add.class})
    @Length(min = 1, max = 3, message = "{user.name.length.illegal}",groups = Add.class)
    private String name;
    @Min(value = 18, message = "年龄不能小于18岁",groups = Update.class)
    private Integer age;
    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$", message = "{phone.error}")
    private String phone;
    @Email(message = "邮箱格式错误")
    private String email;


}
