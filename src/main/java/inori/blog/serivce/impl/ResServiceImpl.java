package inori.blog.serivce.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import inori.blog.dao.ResMapper;
import inori.blog.model.Res;
import inori.blog.serivce.IResService;
import org.springframework.stereotype.Service;

/**
 * @author Inori
 */
@Service
public class ResServiceImpl extends ServiceImpl<ResMapper, Res> implements IResService {

}
