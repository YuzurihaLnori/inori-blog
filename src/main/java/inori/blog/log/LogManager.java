package inori.blog.log;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.TimerTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 日志管理器
 *
 * @author Inori
 */
public class LogManager {
    /**
     * 日志记录操作延时
     */
    private static final int OPERATE_DELAY_TIME = 10;

    public static LogManager logManager = new LogManager();


    /**
     * 异步操作记录日志的线程池
     */
    private ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(10, new BasicThreadFactory.Builder().namingPattern("access-pool-%d").daemon(true).build());


    private LogManager() {
    }


    public static LogManager me() {
        return logManager;
    }


    public void executeLog(TimerTask task) {
        executor.schedule(task, OPERATE_DELAY_TIME, TimeUnit.MILLISECONDS);
    }


}
