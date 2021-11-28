package inori.blog.dao;

import com.baomidou.mybatisplus.plugins.Page;
import inori.blog.transfer.message.MessageCreateInVo;
import inori.blog.transfer.message.MessageDeleteInVo;
import inori.blog.transfer.message.MessageListInVo;
import inori.blog.transfer.message.MessageListOutVoRecords;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Lnori
 */
public interface MessageMapper {

    /**
     * 留言列表
     *
     * @param page 分页
     * @param inVo 条件
     * @return 列表
     */
    List<MessageListOutVoRecords> messageList(@Param("page") Page<MessageListOutVoRecords> page, @Param("inVo") MessageListInVo inVo);


    /**
     * 留言总条数
     *
     * @return 总条数
     */
    Integer getTotalNumber();


    /**
     * 录入留言
     *
     * @param inVo 条件
     */
    void messageCreate(MessageCreateInVo inVo);


    /**
     * 删除留言
     *
     * @param inVo 条件
     */
    void messageDelete(MessageDeleteInVo inVo);


}
