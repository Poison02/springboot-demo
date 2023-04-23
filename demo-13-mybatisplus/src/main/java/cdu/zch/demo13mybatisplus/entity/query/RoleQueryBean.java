package cdu.zch.demo13mybatisplus.entity.query;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zch
 **/
@Data
@NoArgsConstructor
public class RoleQueryBean {

    /**
     * contains name pattern.
     */
    private String name;

    /**
     * contains desc pattern.
     */
    private String description;


    private String roleKey;

}
