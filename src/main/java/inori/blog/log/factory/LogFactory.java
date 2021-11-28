package inori.blog.log.factory;


import inori.blog.model.Log;
import org.apache.commons.lang.time.DateFormatUtils;

import java.util.Date;

/**
 * 日志对象创建工厂
 *
 * @author Inori
 */
public class LogFactory {

    /**
     * 创建登录日志
     */
    public static Log createOperationLog(String ip, String content) {
        Log log = new Log();
        log.setIp(ip);
        log.setContent(content);
        log.setCreateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        return log;
    }
}
