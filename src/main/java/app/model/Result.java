/*
 *Copyright © 2007-2018 DXY All Rights Reserved.
 */
package app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author maxcess
 * @since 2018/2/27
 * if you have any problem  please send to mabin@dxy.cn
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private int code;
    private String message;
    private T data;
    private List<T> datas;

    public static <T> Result<T> error(String message) {
        return new Result<T>(500, message, null, null);
    }

    public static <T> Result<T> data(String message, T data) {
        return new Result<T>(200, message, data, null);
    }

    public static <T> Result<T> datas(String message, List<T> datas) {
        return new Result<T>(200, message, null, datas);
    }
}
