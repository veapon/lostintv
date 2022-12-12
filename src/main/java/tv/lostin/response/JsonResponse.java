package tv.lostin.response;

import java.io.Serializable;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.Data;

@Data
public class JsonResponse<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer code;

    private String msg;

    private T data;

    public JsonResponse() {}

    private static final Integer CODE_SUCCESS = 0;
    private static final Integer CODE_FAILED = 500;
    private static final String MSG_SUCCESS = "Success";
    private static final String MSG_FAILED = "Unknown error";

    /**
     * 操作成功
     *
     * @return
     */
    public static <T> JsonResponse<T> success() {
        return restResult(CODE_SUCCESS, MSG_SUCCESS, null);
    }

    /**
     * 操作成功
     *
     * @param data 数据结果
     * @return
     */
    public static <T> JsonResponse<T> success(T data) {
        return restResult(CODE_SUCCESS, MSG_SUCCESS, data);
    }

    /**
     * 操作成功
     *
     * @param data  数据结果
     * @param msg   返回的消息
     * @return
     */
    public static <T> JsonResponse<T> success(T data, String msg) {
        return restResult(CODE_SUCCESS, msg, data);
    }

    /**
     * 操作失败
     *
     * @return
     */
    public static <T> JsonResponse<T> fail() {
        return restResult(CODE_FAILED, MSG_FAILED, null);
    }

    /**
     * 操作失败
     *
     * @param code  操作响应码
     * @param msg   返回的消息
     * @return
     */
    public static <T> JsonResponse<T> fail(Integer code, String msg) {
        return restResult(code, msg, null);
    }

    /**
     * 操作失败
     *
     * @param msg   返回的消息
     * @return
     */
    public static <T> JsonResponse<T> fail(String msg) {
        return restResult(CODE_FAILED, msg, null);
    }

    /**
     * 操作失败
     *
     * @param code  操作响应码
     * @param msg   返回的消息
     * @param data 数据结果
     * @return
     */
    public static <T> JsonResponse<T> fail(Integer code, String msg, T data) {
        return restResult(code, msg, data);
    }

    /** 对象创建 **/
    private static <T> JsonResponse<T> restResult(Integer code, String msg, T data) {
        JsonResponse<T> responseData = new JsonResponse<>();
        responseData.setCode(code);
        responseData.setMsg(msg);
        responseData.setData(data);
        return responseData;
    }

    @SneakyThrows
    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(data);
        return "{"
                + "\"code\":"
                + code
                + ",\"msg\":\""
                + msg + '\"'
                + ",\"data\":"
                + json
                + "}";
    }
}
