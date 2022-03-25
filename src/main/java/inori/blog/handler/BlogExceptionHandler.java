package inori.blog.handler;


import inori.blog.common.HttpContext;
import inori.blog.common.response.ErrorResponseData;
import inori.blog.common.response.RestResponse;
import io.jsonwebtoken.ExpiredJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 全局的的异常拦截器
 *
 * @author Inori
 */
@Order(-1)
@ControllerAdvice
public class BlogExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(BlogExceptionHandler.class);


    /**
     * 参数校验异常
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public RestResponse handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();

        // 所有参数异常信息
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        List<String> errorsMessageList = new ArrayList<>();
        allErrors.forEach(error -> {
            errorsMessageList.add(error.getDefaultMessage());
        });
        String errorMsg = String.join(";", errorsMessageList);
        return RestResponse.fail(errorMsg);
    }


    /**
     * 拦截未知的运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponseData notFount(RuntimeException e) {
        log.error("运行时异常:", e);
        return new ErrorResponseData(500, e.getMessage(), "Internal Server Error", Objects.requireNonNull(HttpContext.getRequest()).getRequestURI());
    }


    /**
     * token过期异常
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(ExpiredJwtException.class)
    @ResponseBody
    public RestResponse tokenExpired(ExpiredJwtException e) {
        return RestResponse.fail(RestResponse.CODE_TOKEN_EXPIRED, "token过期:" + e.getMessage());
    }

}
