package inori.blog.interceptor;


import com.alibaba.fastjson.JSON;
import inori.blog.common.controller.BaseRestController;
import inori.blog.common.response.RestResponse;
import inori.blog.model.User;
import inori.blog.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Inori
 */
@Slf4j
@Component
public class LoginInterceptor extends BaseRestController implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //设置编码格式
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");

        User user = getUser();
        if (StringUtil.isNull(user)) {
            RestResponse resp = RestResponse.fail("请先进行登录").setCode(RestResponse.CODE_TOKEN_NOTFOUND);
            try (PrintWriter printWriter = response.getWriter()) {
                printWriter.write(JSON.toJSONString(resp));
            } catch (IOException e) {
                log.info(e.getMessage(), e);
            }
            return false;
        }

        return true;
    }


}