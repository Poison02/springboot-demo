package cdu.zch.demo11nettysocketio.payload;

import lombok.Data;

/**
 * @author Zch
 **/
@Data
public class BroadcastMessageRequest {

    /**
     * 消息内容
     */
    private String message;

}
