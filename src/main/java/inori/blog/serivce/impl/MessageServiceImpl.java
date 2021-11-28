package inori.blog.serivce.impl;

import com.baomidou.mybatisplus.plugins.Page;
import inori.blog.dao.MessageMapper;
import inori.blog.serivce.IMessageService;
import inori.blog.transfer.message.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lnori
 */
@Service
public class MessageServiceImpl implements IMessageService {
    @Autowired
    private MessageMapper messageMapper;


    @Override
    public MessageListOutVo messageList(MessageListInVo inVo) {
        Page<MessageListOutVoRecords> page = new Page<>(inVo.getPageNo(), inVo.getPageSize());
        List<MessageListOutVoRecords> recordsList = messageMapper.messageList(page, inVo);

        List<MessageListOutVoRecords> replyRecordsList = new ArrayList<>();
        for (MessageListOutVoRecords records : recordsList) {
            if (!CollectionUtils.isEmpty(records.getMessageReplyList())) {
                recursively(records, replyRecordsList);
                records.setMessageReplyList(replyRecordsList);
                replyRecordsList = new ArrayList<>();
            }
        }

        MessageListOutVo outVo = new MessageListOutVo();
        outVo.setTotalNumber(messageMapper.getTotalNumber());
        outVo.setTotal((int) page.getTotal());
        outVo.setRecords(recordsList);
        return outVo;
    }


    /**
     * 递归迭代，剥洋葱
     */
    public void recursively(MessageListOutVoRecords records, List<MessageListOutVoRecords> replyRecordsList) {
        if (!CollectionUtils.isEmpty(records.getMessageReplyList())) {
            List<MessageListOutVoRecords> recordsList = records.getMessageReplyList();
            for (MessageListOutVoRecords replyRecord : recordsList) {
                replyRecordsList.add(replyRecord);
                if (!CollectionUtils.isEmpty(records.getMessageReplyList())) {
                    recursively(replyRecord, replyRecordsList);
                }
            }
        }
    }


    @Override
    public void messageCreate(MessageCreateInVo inVo) {
        messageMapper.messageCreate(inVo);
    }


    @Override
    public void messageDelete(MessageDeleteInVo inVo) {
        messageMapper.messageDelete(inVo);
    }


}
