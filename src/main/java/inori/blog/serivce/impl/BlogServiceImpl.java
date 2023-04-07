package inori.blog.serivce.impl;

import com.baomidou.mybatisplus.plugins.Page;
import inori.blog.dao.BlogMapper;
import inori.blog.serivce.IBlogService;
import inori.blog.transfer.blog.*;
import inori.blog.utils.MarkdownUtil;
import inori.blog.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Lnori
 */
@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private TemplateEngine templateEngine;

    @Value("${inori.oss.httpBase}")
    private String httpBase;


    @Override
    public void blogDetail(BlogDetailInVo inVo) {
        Integer blogId = inVo.getBlogId();
        PrintWriter writer = null;
        try {
            blogMapper.blogViews(blogId);

            File file = new File("/apps/dev/inori-blog-portal/page" + blogId + ".html");
            if (!file.exists()) {
                System.out.println("创建静态文件");
                BlogDetailOutVo outVo = blogMapper.blogDetail(inVo);
                outVo.setFirstPicturePath(httpBase + outVo.getFirstPicturePath());
                outVo.setContent(MarkdownUtil.markdownToHtmlExtensions(outVo.getContent()));

                Map<String, Object> map = new HashMap<>();
                map.put("item", outVo);
                // 创建thymeleaf上下文对象
                Context context = new Context();
                // 把数据放入上下文对象
                context.setVariables(map);

                // 创建输出流
                writer = new PrintWriter(file, "UTF-8");

                // 执行页面静态化方法
                templateEngine.process("blog", context, writer);
            }
        } catch (Exception ignored) {
        } finally {
            if (StringUtil.isNotNull(writer)) {
                writer.close();
            }
        }
    }


    @Override
    public BlogRecommendOutVo blogRecommend(BlogRecommendInVo inVo) {
        BlogRecommendOutVo outVo = blogMapper.blogRecommend(inVo);
        if (StringUtil.isNotNull(outVo.getPrevious())) {
            outVo.getPrevious().setFirstPicturePath(httpBase + outVo.getPrevious().getFirstPicturePath());
        }
        if (StringUtil.isNotNull(outVo.getNext())) {
            outVo.getNext().setFirstPicturePath(httpBase + outVo.getNext().getFirstPicturePath());
        }
        return outVo;
    }


    @Override
    public CommentListOutVo commentList(CommentListInVo inVo) {
        Page<CommentListOutVoRecords> page = new Page<>(inVo.getPageNo(), inVo.getPageSize());
        List<CommentListOutVoRecords> recordsList = blogMapper.commentList(page, inVo);

        List<CommentListOutVoRecords> replyRecordsList = new ArrayList<>();
        for (CommentListOutVoRecords records : recordsList) {
            if (!CollectionUtils.isEmpty(records.getCommentReplyList())) {
                recursively(records, replyRecordsList);
                records.setCommentReplyList(replyRecordsList);
                replyRecordsList = new ArrayList<>();
            }
        }

        CommentListOutVo outVo = new CommentListOutVo();
        outVo.setTotalNumber(blogMapper.getTotalNumber(inVo.getBlogId()));
        outVo.setTotal((int) page.getTotal());
        outVo.setRecords(recordsList);
        return outVo;
    }


    /**
     * 递归迭代，剥洋葱
     */
    public void recursively(CommentListOutVoRecords records, List<CommentListOutVoRecords> replyRecordsList) {
        if (!CollectionUtils.isEmpty(records.getCommentReplyList())) {
            List<CommentListOutVoRecords> recordsList = records.getCommentReplyList();
            for (CommentListOutVoRecords replyRecord : recordsList) {
                replyRecordsList.add(replyRecord);
                if (!CollectionUtils.isEmpty(records.getCommentReplyList())) {
                    recursively(replyRecord, replyRecordsList);
                }
            }
        }
    }


    @Override
    public void commentCreate(CommentCreateInVo inVo) {
        blogMapper.commentCreate(inVo);
    }


    @Override
    public void commentDelete(CommentDeleteInVo inVo) {
        blogMapper.commentDelete(inVo);
    }


}
