package inori.blog.aop;


import inori.blog.annotion.AccessLog;
import inori.blog.common.HttpContext;
import inori.blog.log.LogManager;
import inori.blog.log.factory.LogTaskFactory;
import inori.blog.utils.IpUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * 记录访问日志
 *
 * @author Inori
 */
@Aspect
@Component
public class LogAop {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut(value = "@annotation(inori.blog.annotion.AccessLog)")
    public void cutService() {
    }

    @Around("cutService()")
    public Object recordSysLog(ProceedingJoinPoint point) throws Throwable {
        //先执行业务
        Object result = point.proceed();
        try {
            handle(point);
        } catch (Exception e) {
            log.error("日志记录错误!", e);
        }
        return result;
    }

    private void handle(ProceedingJoinPoint point) throws Exception {
        //获取拦截的方法
        Signature signature = point.getSignature();
        MethodSignature methodSignature;
        if (!(signature instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        methodSignature = (MethodSignature) signature;
        Object target = point.getTarget();

        Method currentMethod = target.getClass().getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
        AccessLog annotation = currentMethod.getAnnotation(AccessLog.class);
        //获取操作名称
        String value = annotation.value();

        LogManager.me().executeLog(LogTaskFactory.log(IpUtil.getIpAddress(Objects.requireNonNull(HttpContext.getRequest())), value));
    }

}
