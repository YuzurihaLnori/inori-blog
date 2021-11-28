package inori.blog.controller;

import inori.blog.annotion.AccessLog;
import inori.blog.common.response.RestResponse;
import inori.blog.serivce.IMessageService;
import inori.blog.transfer.message.MessageCreateInVo;
import inori.blog.transfer.message.MessageDeleteInVo;
import inori.blog.transfer.message.MessageListInVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lnori
 */
@RestController
@RequestMapping("/api")
public class MessageController {
    @Autowired
    private IMessageService messageService;


    @AccessLog("评论列表")
    @PostMapping("/message/list")
    public RestResponse messageList(@RequestBody(required = true) @Validated MessageListInVo inVo) {
        return RestResponse.success(messageService.messageList(inVo));
    }


    @PostMapping("/message/create")
    public RestResponse messageCreate(@RequestBody(required = true) @Validated MessageCreateInVo inVo) {
        messageService.messageCreate(inVo);
        return RestResponse.success();
    }


    @PostMapping("/message/delete")
    public RestResponse messageDelete(@RequestBody(required = true) @Validated MessageDeleteInVo inVo) {
        messageService.messageDelete(inVo);
        return RestResponse.success();
    }


}
