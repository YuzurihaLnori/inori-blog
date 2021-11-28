package inori.blog.common.controller;


import inori.blog.common.HttpContext;
import inori.blog.common.constants.JwtConstants;
import inori.blog.model.User;
import inori.blog.serivce.IUserService;
import inori.blog.utils.JwtTokenUtil;
import inori.blog.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

/**
 * @author Inori
 */
public class BaseRestController {
    @Autowired
    private IUserService userService;

    private static final String INORI = "inori";

    private static final String ADMIN = "admin";


    /**
     * 获取token
     */
    protected String getJwtToken() {
        String requestHeader = Objects.requireNonNull(HttpContext.getRequest()).getHeader(JwtConstants.AUTH_HEADER);
        String authToken;
        if (requestHeader != null && requestHeader.startsWith(JwtConstants.BEARER)) {
            authToken = requestHeader.substring(7);
        } else {
            authToken = requestHeader;
        }
        return authToken;
    }


    /**
     * 获取当前用户的ID
     */
    protected String getUserAccount() {
        String token = getJwtToken();
        if (StringUtil.isNotBlank(token)) {
            String username = JwtTokenUtil.getUsernameFromToken(token);
            String[] split = username.split(":");
            if (!split[0].equals(INORI) && !split[1].equals(ADMIN)) {
                return "";
            }
            return split[split.length - 1];
        }
        return "";
    }


    /**
     * 获取当前用户
     */
    protected User getUser() {
        String userAccount = getUserAccount();
        if (StringUtil.isBlank(userAccount)) {
            return null;
        }
        return userService.selectById(userAccount);
    }


}
