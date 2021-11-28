package inori.blog.serivce;

import com.baomidou.mybatisplus.service.IService;
import inori.blog.common.controller.BaseRestController;
import inori.blog.common.response.RestResponse;
import inori.blog.model.User;
import inori.blog.transfer.user.UserInfoInVo;
import inori.blog.transfer.user.UserLoginInVo;

/**
 * @author Inori
 */
public interface IUserService extends IService<User> {

    /**
     * 用户登陆
     *
     * @param controller 枷锁
     * @param inVo       条件
     * @return Json
     */
    RestResponse userLogin(BaseRestController controller, UserLoginInVo inVo);


    /**
     * 用户信息
     *
     * @param controller 枷锁
     * @param inVo       条件
     * @return Json
     */
    RestResponse userInfo(BaseRestController controller, UserInfoInVo inVo);

}
