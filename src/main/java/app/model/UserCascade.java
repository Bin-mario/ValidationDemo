/*
 *Copyright © 2007-2018 DXY All Rights Reserved.
 */
package app.model;

import app.group.First;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author maxcess since 2018/3/15
 * @e-mail mabin@dxy.cn
 */
@Data
public class UserCascade {
    @NotNull
    private Integer id;
    @NotBlank(message = "姓名不能为空",groups = First.class)
    private String name;
    @Valid
//    @ConvertGroup(from = First.class,to = Second.class)
    private School school;
}
