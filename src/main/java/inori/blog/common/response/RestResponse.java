package inori.blog.common.response;

/**
 * @author Inori
 */
public class RestResponse {
    public static final int CODE_SUCCESS = 200;
    public static final int CODE_VERSION_NONSUPPORT = 305;
    public static final int CODE_PARAM_ERROR = 400;
    public static final int CODE_TOKEN_EXPIRED = 402;
    public static final int CODE_TOKEN_NOTFOUND = 403;
    public static final int CODE_FORBIDDEN = 406;
    public static final int CODE_SERVER_ERROR = 500;


    private int code;
    private String msg;
    private Object data = null;

    public static RestResponse success() {
        RestResponse restResponse = new RestResponse();
        restResponse.setCode(200);
        restResponse.setData(new Object());
        return restResponse;
    }

    public static RestResponse success(Object data) {
        RestResponse restResponse = new RestResponse();
        restResponse.setCode(200);
        restResponse.setData(data);
        return restResponse;
    }

    public static RestResponse fail(int code, String msg) {
        RestResponse restResponse = new RestResponse();
        restResponse.setCode(code);
        restResponse.setMsg(msg);
        return restResponse;
    }

    public static RestResponse error(String msg) {
        RestResponse restResponse = new RestResponse();
        restResponse.setCode(CODE_SERVER_ERROR);
        restResponse.setMsg(msg);
        return restResponse;
    }

    public boolean isSuccess() {
        return CODE_SUCCESS == this.code;
    }

    public static RestResponse fail(String msg) {
        return fail(CODE_PARAM_ERROR, msg);
    }

    public int getCode() {
        return code;
    }

    public RestResponse setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        if (data == null) {
            return new Object();
        }
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
