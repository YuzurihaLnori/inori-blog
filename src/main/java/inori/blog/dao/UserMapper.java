package inori.blog.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import inori.blog.model.User;

/**
 * @author Inori
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 用户信息
     *
     * @param userId 用户ID
     * @return 信息
     */
    User userInfo(Integer userId);

}
