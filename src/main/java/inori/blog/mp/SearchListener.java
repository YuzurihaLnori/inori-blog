package inori.blog.mp;

import inori.blog.serivce.ISearchService;
import inori.blog.utils.StringUtil;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Lnori
 */
@Component
public class SearchListener {
    @Autowired
    private ISearchService searchService;


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "search.insert.queue", durable = "true"),
            exchange = @Exchange(name = "search.exchange", type = ExchangeTypes.TOPIC),
            key = {"search.insert", "search.update"}
    ))
    public void listenerInsertOrUpdate(Integer id) {
        if (StringUtil.isNull(id)) {
            return;
        }
        //处理消息，对索引库进行新增或修改
        searchService.searchCreateOrUpdate(id);
    }


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "search.delete.queue", durable = "true"),
            exchange = @Exchange(name = "search.exchange", type = ExchangeTypes.TOPIC),
            key = {"search.delete"}
    ))
    public void listenerDelete(Integer id) {
        if (StringUtil.isNull(id)) {
            return;
        }
        //处理消息，对索引库进行删除
        searchService.searchDelete(id);
    }


}
