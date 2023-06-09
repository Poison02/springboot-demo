package cdu.zch.demo18swagger.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Zch
 * @data 2023/5/16
 **/
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(name = "User", description = "用户信息")
public class User implements Serializable {

    private static final long serialVersionUID = -583023130164283193L;
    @Schema(name = "id", description = "用户id")
    private Long id;
    @Schema(name = "username", description = "用户名")
    private String username;
    @Schema(name = "password", description = "密码")
    private String password;
}