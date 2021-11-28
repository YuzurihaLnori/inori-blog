package inori.blog.log.factory;


import inori.blog.dao.LogMapper;
import inori.blog.common.SpringContextHolder;
import inori.blog.model.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TimerTask;

/**
 * 日志操作任务创建工厂
 *
 * @author Inori
 */
public class LogTaskFactory {
    private static Logger logger = LoggerFactory.getLogger(LogTaskFactory.class);
    private static LogMapper logMapper = SpringContextHolder.getBean(LogMapper.class);

    public static TimerTask log(final String ipAddress, final String content) {
        return new TimerTask() {
            @Override
            public void run() {
                Log sysLog = LogFactory.createOperationLog(ipAddress, content);
                try {
                    logMapper.insert(sysLog);
                } catch (Exception e) {
                    logger.error("日志创建失败!", e);
                }
            }
        };
    }

}
