package inori.blog.serivce.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import inori.blog.common.controller.BaseRestController;
import inori.blog.common.response.RestResponse;
import inori.blog.dao.UserMapper;
import inori.blog.model.User;
import inori.blog.serivce.IUserService;
import inori.blog.transfer.user.UserInfoInVo;
import inori.blog.transfer.user.UserInfoOutVo;
import inori.blog.transfer.user.UserLoginInVo;
import inori.blog.transfer.user.UserLoginOutVo;
import inori.blog.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Inori
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Value("${inori.oss.httpBase}")
    private String httpBase;

    @Value("${inori.token.tokenPrefix}")
    private String tokenPrefix;


    @Override
    public RestResponse userLogin(BaseRestController controller, UserLoginInVo inVo) {
        User user = new User();
        user.setAccount(inVo.getAccount());
        user.setPassword(MD5Util.encrypt(inVo.getAccount() + inVo.getPassword()));
        User result = userMapper.selectOne(user);
        if (StringUtil.isNull(result)) {
            return RestResponse.fail("账号或密码不正确");
        }
        return RestResponse.success(new UserLoginOutVo(JwtTokenUtil.generateToken(tokenPrefix + result.getId().toString())));
    }


    @Override
    public RestResponse userInfo(BaseRestController controller, UserInfoInVo inVo) {
        UserInfoOutVo outVo = new UserInfoOutVo();
        if (StringUtil.isNotBlank(inVo.getUserId())) {
            User user = userMapper.userInfo(Integer.parseInt(inVo.getUserId()));
            if (StringUtil.isNotNull(user)) {
                outVo.setAvatar(httpBase + user.getAvatarUrl());
                outVo.setNickName(user.getName());
                outVo.setEmail(user.getEmail());
                outVo.setFlag(true);
            }
        } else {
            String nickName = inVo.getNickName();
            if (StringUtil.isNotBlank(inVo.getNickName()) && StringUtil.isStr2Num(nickName)) {
                String result = HttpUtil.sendGet("https://r.qzone.qq.com/fcg-bin/cgi_get_portrait.fcg?g_tk=&uins=" + nickName);
                String name = result.substring(result.indexOf("{") + 2, result.indexOf(":") - 1);
                if (!"error".equals(name)) {
                    String substring = result.substring(result.indexOf("["), result.indexOf("]") + 1);
                    List<String> list = JsonUtil.toList(substring, String.class);
                    outVo.setAvatar("https://q.qlogo.cn/headimg_dl?dst_uin=" + nickName + "&spec=100&img_type=jpg");
                    outVo.setNickName(list.get(6));
                    outVo.setEmail(name + "@qq.com");
                    outVo.setFlag(false);
                } else {
                    return RestResponse.success(outVo);
                }
            } else {
                return RestResponse.success(outVo);
            }

        }
        return RestResponse.success(outVo);
    }


}
