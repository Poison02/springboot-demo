package cdu.zch.demo16cos.utils;

import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zch
 * @data 2023/4/26
 **/
public class ResponseUtils extends HashMap<String, Object> {

    public ResponseUtils() {
        put("code", HttpStatus.SC_OK);
        put("msg", "success");
    }
    @Override

    public ResponseUtils put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public static ResponseUtils ok() {
        return new ResponseUtils();
    }

    public static ResponseUtils ok(String msg) {
        ResponseUtils r = new ResponseUtils();
        r.put("msg", msg);
        return r;
    }

    public static ResponseUtils ok(Map<String, Object> map) {
        ResponseUtils r = new ResponseUtils();
        r.putAll(map);
        return r;
    }

    public static ResponseUtils error(int code, String msg) {
        ResponseUtils r = new ResponseUtils();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static ResponseUtils error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    public static ResponseUtils error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

}
