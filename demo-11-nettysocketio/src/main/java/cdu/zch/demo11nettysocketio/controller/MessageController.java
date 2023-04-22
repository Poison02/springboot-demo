package cdu.zch.demo11nettysocketio.controller;

import cdu.zch.demo11nettysocketio.handler.MessageEventHandler;
import cdu.zch.demo11nettysocketio.payload.BroadcastMessageRequest;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;

/**
 * @author Zch
 **/
@RestController
@RequestMapping("/send")
@Slf4j
public class MessageController {

    @Autowired
    private MessageEventHandler messageEventHandler;

    @PostMapping("/broadcast")
    public Dict broadcast(@RequestBody BroadcastMessageRequest message) {
        if (isBlank(message)) {
            return Dict.create().set("flag", false).set("code", 400).set("message", "参数为空");
        }
        messageEventHandler.sendToBroadcast(message);
        return Dict.create().set("flag", true).set("code", 200).set("message", "发送成功");
    }

    /**
     * 判断Bean是否为空对象或者空白字符串，空对象表示本身为null或者所有属性都为null
     * @param bean Bean 对象
     * @return 是否为空，
     */
    public boolean isBlank(Object bean) {
        if (null != bean) {
            for (Field field: ReflectUtil.getFields(bean.getClass())) {
                Object fieldValue = ReflectUtil.getFieldValue(bean, field);
                if (null != fieldValue) {
                    if (fieldValue instanceof String && StrUtil.isNotBlank((String) fieldValue)) {
                        return false;
                    } else if (!(fieldValue instanceof String)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
