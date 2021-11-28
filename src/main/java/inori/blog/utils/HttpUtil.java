package inori.blog.utils;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 发送请求工具类
 *
 * @author Lnori
 */
public class HttpUtil {
    private static final Logger log = LoggerFactory.getLogger(HttpUtil.class);

    /**
     * 发送Get请求
     *
     * @param url url
     * @return 结果
     */
    public static String sendGet(String url) {
        log.info("【Get请求】Url: {}", url);
        /*
         * 1.生成HttpClient对象并设置参数
         */
        HttpClient httpClient = new HttpClient();
        //设置Http连接超时为10秒
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(10000);

        /*
         * 2.生成GetMethod对象并设置参数
         */
        GetMethod getMethod = new GetMethod(url);
        //设置get请求超时为10秒
        getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 10000);
        //设置请求重试处理，用的是默认的重试处理：请求三次
        getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());

        String response;
        /*
         * 3.执行HTTP GET 请求
         */
        try {
            int statusCode = httpClient.executeMethod(getMethod);

            /*
             * 4.判断访问的状态码
             */
            if (statusCode != HttpStatus.SC_OK) {
                log.error("请求出错：{}", getMethod.getStatusLine());
            }

            /*
             * 5.处理HTTP响应内容
             */
            //读取为字节数组
            byte[] responseBody = getMethod.getResponseBody();
            response = new String(responseBody, "GBK");
            log.info("【Get请求】返回值: {}", response);
            return response;
        } catch (HttpException e) {
            log.error("请检查输入的URL!");
        } catch (IOException e) {
            log.error("发生网络异常!");
        } finally {
            /*
             * 6.释放连接
             */
            getMethod.releaseConnection();
            httpClient.getHttpConnectionManager().closeIdleConnections(0L);
        }
        return "";
    }


    public static String sendPost(String url, String json) {
        log.info("【Post请求】Url: {}", url);
        /*
         * 1.生成HttpClient对象并设置参数
         */
        HttpClient httpClient = new HttpClient();
        //设置Http连接超时为10秒
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(10000);

        /*
         * 2.生成PostMethod对象并设置参数
         */
        PostMethod postMethod = new PostMethod(url);
        //设置post请求超时为10秒
        postMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 10000);
        //设置请求重试处理，用的是默认的重试处理：请求三次
        postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
        //设置请求头
        postMethod.addRequestHeader("Content-Type", "application/json");

        /*
         * 3.执行HTTP GET 请求
         */
        String response = "";
        try {
            //json格式的参数解析
            RequestEntity entity = new StringRequestEntity(json, "application/json", "UTF-8");
            postMethod.setRequestEntity(entity);

            int statusCode = httpClient.executeMethod(postMethod);

            /*
             * 4.判断访问的状态码
             */
            if (statusCode != HttpStatus.SC_OK) {
                log.error("请求出错：{}", postMethod.getStatusLine());
            }

            /*
             * 5.处理HTTP响应内容
             */
            byte[] responseBody = postMethod.getResponseBody();
            response = new String(responseBody, StandardCharsets.UTF_8);
            log.info("【Post请求】返回值: {}", response);
            return response;
        } catch (HttpException e) {
            log.error("请检查输入的URL!");
        } catch (IOException e) {
            log.error("发生网络异常!");
        } finally {
            /*
             * 6.释放连接
             */
            postMethod.releaseConnection();
            httpClient.getHttpConnectionManager().closeIdleConnections(0L);
        }
        return "";
    }


}
