/*
 *Copyright © 2007-2018 DXY All Rights Reserved.
 */
package app.model;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

/**
 * @author maxcess
 * @since 2018/2/10
 * if you have any problem  please send to mabin@dxy.cn
 */
@Data
public class User {
    @Length(min = 1, max = 3, message = "用户名【${validatedValue}】长度必须在{min}到{max}之间")
    private String name;
    @Min(value = 18, message = "年龄不能小于{value}岁")
    private Integer age;
    @Pattern(regexp = "1(3|4|5|7|8)\\d{9}$", message = "{phone.error}")
    private String phone;
    @Email(message = "邮箱格式错误")
    private String email;

}
