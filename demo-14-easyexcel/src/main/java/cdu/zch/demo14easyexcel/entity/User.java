package cdu.zch.demo14easyexcel.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.*;

/**
 * @author Zch
 **/
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements BaseEntity {

    /**
     * user id.
     */
    @ExcelProperty("ID")
    private Long id;

    /**
     * username.
     */
    @ExcelProperty("Name")
    private String userName;

    /**
     * email.
     */
    @ExcelProperty("Email")
    private String email;

    /**
     * phoneNumber.
     */
    @ExcelProperty("Phone")
    private long phoneNumber;

    /**
     * description.
     */
    @ExcelProperty("Description")
    private String description;


}
