package inori.blog.controller;

import inori.blog.common.controller.BaseRestController;
import inori.blog.common.response.RestResponse;
import inori.blog.serivce.IUserService;
import inori.blog.transfer.user.UserInfoInVo;
import inori.blog.transfer.user.UserLoginInVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Inori
 */
@RestController
@RequestMapping("/api")
public class UserController extends BaseRestController {
    @Autowired
    private IUserService userService;


    @PostMapping("/user/login")
    public RestResponse userLogin(@RequestBody(required = true) @Validated UserLoginInVo inVo) {
        return userService.userLogin(this, inVo);
    }


    @PostMapping("/user/info")
    public RestResponse userInfo(@RequestBody(required = true) @Validated UserInfoInVo inVo) {
        inVo.setUserId(this.getUserAccount());
        return userService.userInfo(this, inVo);
    }


}
