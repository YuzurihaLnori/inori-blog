package inori.blog.serivce;

import inori.blog.transfer.message.MessageCreateInVo;
import inori.blog.transfer.message.MessageDeleteInVo;
import inori.blog.transfer.message.MessageListInVo;
import inori.blog.transfer.message.MessageListOutVo;

/**
 * @author Lnori
 */
public interface IMessageService {

    /**
     * 留言列表
     *
     * @param inVo 条件
     * @return 列表
     */
    MessageListOutVo messageList(MessageListInVo inVo);

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
