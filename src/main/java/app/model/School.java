/*
 *Copyright © 2007-2018 DXY All Rights Reserved.
 */
package app.model;

import app.group.First;
import app.group.Second;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author maxcess since 2018/3/15
 * @e-mail mabin@dxy.cn
 */
@Data
public class School {
    @NotBlank(message = "学校名称不能为空",groups = Second.class)
    private String name;

    @NotBlank(message = "学校地址不能为空",groups = First.class)
    private String address;
}
