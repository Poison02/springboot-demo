package cdu.zch.demo13mybatisplus.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author Zch
 **/
@Data
@Getter
@Setter
public class Role implements BaseEntity{

    /**
     * role id.
     */
    private Long id;

    /**
     * role name.
     */
    private String name;

    /**
     * role key.
     */
    private String roleKey;

    /**
     * description.
     */
    private String description;

    /**
     * create date time.
     */
    private LocalDateTime createTime;

    /**
     * update date time.
     */
    private LocalDateTime updateTime;

}
