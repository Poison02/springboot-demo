package cdu.zch.demo11nettysocketio.payload;

import lombok.Data;

/**
 * @author Zch
 **/
@Data
public class GroupMessageRequest {

    /**
     * 消息发送方用户id
     */
    private String fromUid;

    /**
     * 群组id
     */
    private String groupId;

    /**
     * 消息内容
     */
    private String message;

}
