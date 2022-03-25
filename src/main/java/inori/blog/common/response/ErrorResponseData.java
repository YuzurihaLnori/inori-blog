package inori.blog.common.response;


import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 请求失败的返回
 *
 * @author stylefeng
 * @Date 2018/1/4 22:39
 */
@Data
public class ErrorResponseData {

    /**
     * 响应时间
     */
    private String timestamp;

    /**
     * 响应状态码
     */
    private Integer status;

    /**
     * 响应信息
     */
    private String message;

    /**
     * 异常的具体类名称
     */
    private String error;

    /**
     * 路径
     */
    private String path;


    public ErrorResponseData(Integer status, String message, String error, String path) {
        this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        this.status = status;
        this.message = message;
        this.error = error;
        this.path = path;
    }

}
