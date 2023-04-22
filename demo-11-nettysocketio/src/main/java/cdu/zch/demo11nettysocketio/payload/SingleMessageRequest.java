package cdu.zch.demo11nettysocketio.payload;

import lombok.Data;

/**
 * @author Zch
 **/
@Data
public class SingleMessageRequest {

    /**
     * 消息发送方id
     */
    private String fromUid;

    /**
     * 消息接收方用户id
     */
    private String toUid;

    /**
     * 消息内容
     */
    private String message;

}
